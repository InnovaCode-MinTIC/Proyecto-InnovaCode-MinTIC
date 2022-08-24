package com.innovacode.InnovaCode.entities;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class User {
    private int id;
    private String username;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        setCreatedAt();
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
        setUpdatedAt();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    private void setCreatedAt() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        this.createdAt = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }

    public void setUpdatedAt() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        this.updatedAt = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }
}
