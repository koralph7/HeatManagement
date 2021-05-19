package com.battman;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class User {

    public static User getUser(JSONObject jsonObject) throws JSONException {
        String userName = jsonObject.getString("username");
        String email = jsonObject.getString("email");
        String token = jsonObject.getString("token");

        User user = new User(userName, email, token);

        return user;

    }

    private String username;
    private String email;
    private String token;

    public User(String username, String email, String token) {
        this.username = username;
        this.email = email;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null && o instanceof User){
            User that = (User) o;
            if (this.username.equalsIgnoreCase(that.email))
            {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + this.username + '\'' +
                '}';
    }
}
