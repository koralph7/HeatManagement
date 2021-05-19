package com.battman;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Battery {

    private String name;
    private String numOfCel2V;
    private String alarm1;
    private String username;

    public static Battery getBattery(JSONObject jsonObject) throws JSONException {
      String name = jsonObject.getString("name");
      String numOfCell2v = jsonObject.getString("numOfCell2v");
      String alarm1 = jsonObject.getString("alarm1");
      String username = jsonObject.getString("username");

      Battery battery = new Battery(name, numOfCell2v, alarm1);
      return battery;
    }

    public static List<Battery> getBatteries(JSONArray jsonArray) throws JSONException {
        List<Battery> batteries = new ArrayList<>();
        for(int i =0; i !=jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            Battery battery = Battery.getBattery(jsonObject);

            batteries.add(battery);


        }

        return batteries;

    }

    public Battery(String name, String numOfCel2V, String alarm1) {
        this.name = name;
        this.numOfCel2V = numOfCel2V;
        this.alarm1 = alarm1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumOfCel2V() {
        return numOfCel2V;
    }

    public void setNumOfCel2V(String numOfCel2V) {
        this.numOfCel2V = numOfCel2V;
    }

    public String getAlarm1() {
        return alarm1;
    }

    public void setAlarm1(String alarm1) {
        this.alarm1 = alarm1;
    }
}
