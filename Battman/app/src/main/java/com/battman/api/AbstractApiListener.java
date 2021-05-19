package com.battman.api;

import com.battman.Battery;
import com.battman.User;

import java.util.List;

public class AbstractApiListener implements ApiListener{
    @Override
    public void onLogin(User user) { }

    @Override
    public void onBatteriesLoaded(List<Battery> batteries) { }
}
