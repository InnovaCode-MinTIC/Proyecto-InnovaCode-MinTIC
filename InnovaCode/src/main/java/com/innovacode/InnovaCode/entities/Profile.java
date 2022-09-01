package com.innovacode.InnovaCode.entities;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@Entity
@Table(name="profile")
public class Profile {

    @Id
    private String id;
    @Column
    private String image;
    @Column
    private String phone;
    @Column
    private String user;
    @Column
    private Date createdAt;
    @Column
    private Date updatedAt;

    public Profile() {
    }

    public Profile(String id, String image, String phone, String user) {
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

    public void setUser(String user) {
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

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "\n\t id='" + id + '\'' +
                "\n\t image='" + image + '\'' +
                "\n\t phone='" + phone + '\'' +
                "\n\t user='" + user + '\'' +
                "\n\t createdAt=" + createdAt +
                "\n\t updatedAt=" + updatedAt +
                '}';
    }
}
