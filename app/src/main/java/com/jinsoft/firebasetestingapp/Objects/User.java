package com.jinsoft.firebasetestingapp.Objects;

/**
 * Created by desa-tecno007 on 2/1/18.
 */

public class User {
    boolean admin;
    String devtoken;
    String email;
    String name;
    int points;
    String user;

    public User(boolean admin, String devtoken, String email, String name, int points, String user) {
        this.admin = admin;
        this.devtoken = devtoken;
        this.email = email;
        this.name = name;
        this.points = points;
        this.user = user;
    }

    public User() {
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getDevtoken() {
        return devtoken;
    }

    public void setDevtoken(String devtoken) {
        this.devtoken = devtoken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
