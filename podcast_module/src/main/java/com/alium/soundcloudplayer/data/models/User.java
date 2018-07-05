package com.alium.soundcloudplayer.data.models;

/**
 * Created by Abdul-Mujeeb Aliu on 21-9-2017
 */
public class User {
    private String username;
    private String userId;

    public User(String username, String userId) {
        this.username = username;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }
}
