    package com.battman;

import android.app.Application;


import com.battman.api.Api;
import com.battman.api.ApiListener;
import com.battman.api.WebApi;

import java.util.ArrayList;
import java.util.List;

    public class Model {

    private static Model sInstance = null;
    private final Api mApi;
    private List<Battery> batteries;

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        this.mUser = user;
    }

    private User mUser;

    public static Model getInstance(Application application){
        if (sInstance == null) {
            sInstance = new Model(application);
        }
        return sInstance;
    }
    private final Application mApplication;

    private Model (Application application) {
        mApplication = application;
        mApi = new WebApi(mApplication, this);
        batteries = new ArrayList<>();
    }

    public Application getAppliction(){
        return mApplication;
    }

    public void login(String username, String password, ApiListener listener){
       mApi.login(username, password, listener);
    }

    public List<Battery> getBatteries(){
        return batteries;
    }

    public void loadBatteries(ApiListener listener) {
            mApi.loadBatteries(listener);
        }
    }
