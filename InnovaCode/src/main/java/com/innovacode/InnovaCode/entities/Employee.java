/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.judalpalau.innovacode.entities;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
/**
 *
 * @author judalpalau
 */

public class Employee {
    
    private enum Enum_RoleName {
        Admin, Operario;
    }
    
    private long id;
    private String email;
    private Profile profile;
    private Enum_RoleName role;
    private Enterprise enterprise;
    private Transaction [] transactions;
    private Date createdAt;
    private Date updatedAt;

    public Employee(long id, String email, Profile profile, Enum_RoleName role, Enterprise enterprise) {
        this.id = id;
        this.email = email;
        this.profile = profile;
        this.role = role;
        this.enterprise = enterprise;
        setCreatedAt();
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Profile getProfile() {
        return profile;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
        setUpdatedAt();
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
        setUpdatedAt();
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
        setUpdatedAt();
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
        setUpdatedAt();
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
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
