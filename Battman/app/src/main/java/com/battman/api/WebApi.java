package com.battman.api;

import android.app.Application;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.battman.Battery;
import com.battman.Model;
import com.battman.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebApi implements Api {
    public static final String BASE_URL = "http://192.168.1.22:8080/";
    private final Application mApplication;
    private Model mModel;



    private RequestQueue mRequestQueue;

    public WebApi (Application application, Model model) {
        mApplication = application;

        mRequestQueue = Volley.newRequestQueue(application);
       mModel = model;
    }

    @Override
    public void login(String username, String password, final ApiListener listener) {
        String url = BASE_URL+ "api/auth/signin";
        JSONObject jsonObject = new JSONObject();


        try{
            jsonObject.put("username", username);
            jsonObject.put("password", password);

            Response.Listener<JSONObject> successListener = new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {

                        User user = User.getUser(response);
//                        Model model = Model.getInstance(mApplication);
//                        model.setUser(user);
                       listener.onLogin(user);
//                       mModel.setUser(user);
//                        Toast.makeText(mApplication, "Successful response, lololoemail: "
//                                        + user.getEmail(), Toast.LENGTH_SHORT).show();
                    }
                    catch (JSONException e){
                        Toast.makeText(mApplication, "JSON exception", Toast.LENGTH_SHORT).show();
                    }


                }
            };

            Response.ErrorListener errorListener = new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(mApplication, "Error response", Toast.LENGTH_SHORT).show();
                }

            };

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                    successListener, errorListener);
            mRequestQueue.add(request);
        }
        catch (JSONException e) {
            Toast.makeText(mApplication, "JSON exception", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void loadBatteries(final ApiListener listener) {
            String  url = BASE_URL + "battery/all/" + mModel.getUser().getUsername();

            Response.Listener<JSONArray> successListener = new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        List<Battery> batteries = Battery.getBatteries(response);
                        if (listener != null){
                            listener.onBatteriesLoaded(batteries);
                        }

                    }
                    catch (JSONException e){
                        Toast.makeText(mApplication, "JSONException", Toast.LENGTH_LONG).show();
                    }
                }
            };

            Response.ErrorListener errorListener = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(mApplication, "Volley Error " + error.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            };

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                successListener, errorListener) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap();
                headers.put("Content-Type", "application/json");
                headers.put("Accept", "application/json");
                headers.put("Authorization", "Bearer " + mModel.getUser().getToken());
                return headers;

            }
        };
        mRequestQueue.add(request);
    }


}
