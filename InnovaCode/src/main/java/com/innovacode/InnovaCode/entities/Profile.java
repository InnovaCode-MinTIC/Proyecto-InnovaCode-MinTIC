package com.innovacode.InnovaCode.entities;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class Profile {
    private String id;
    private String image;
    private String phone;
    private User user;
    private Date createdAt;
    private Date updatedAt;
    
    public Profile(String id, String image, String phone, User user, Date createdAt, Date updatedAt) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.user = user;
        setCreatedAt();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
        setUpdatedAt();
    }

    public void setPhone(String phone) {
        this.phone = phone;
        setUpdatedAt();
    }

    public void setUser(User user) {
        this.user = user;
        setUpdatedAt();
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

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getPhone() {
        return phone;
    }

    public User getUser() {
        return user;
    }
    
}
