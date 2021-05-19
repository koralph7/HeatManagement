package com.battman.api;

public interface Api {
    void login(String username, String password, ApiListener listener);

    void loadBatteries(ApiListener listener);

}
