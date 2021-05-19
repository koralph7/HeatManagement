package com.battman.api;

import com.battman.Battery;
import com.battman.User;

import java.util.List;

public interface ApiListener {
    void onLogin(User user);

    void onBatteriesLoaded(List<Battery> batteries);
}
