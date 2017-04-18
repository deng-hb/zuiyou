package com.denghb.zuiyou.model;

/**
 * Created by denghb on 2017/4/11.
 */
public class CurrentUser {

    private long userId;

    private String username;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "CurrentUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
