package com.innovacode.InnovaCode.entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Transaction {
    private long id;
    private String concept;
    private float amount;
    private User user;
    private Enterprise enterprise;
    private Date createdAt;
    private Date updatedAt;

    public Transaction(long id, String concept, float amount, User user, Enterprise enterprise) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.user = user;
        this.enterprise = enterprise;
        setCreatedAt();
    }

    public long getId() {
        return id;
    }

    public String getConcept() {
        return concept;
    }

    public float getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setConcept(String concept) {
        this.concept = concept;
        setUpdatedAt();
    }

    public void setAmount(float amount) {
        this.amount = amount;
        setUpdatedAt();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
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
