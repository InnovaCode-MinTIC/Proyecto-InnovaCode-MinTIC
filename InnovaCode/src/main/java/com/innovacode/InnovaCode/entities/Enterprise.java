package com.innovacode.InnovaCode.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enterprise")
public class Enterprise {
    LocalDateTime localDate = LocalDateTime.now(ZoneOffset.UTC);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "document",unique = true)
    private String document;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @OneToMany
    private List<Employee> users;

    @OneToMany
    private List<Transaction> transactions;

    @Column(name = "createdAt")
    private Date createdAt = Date.from(localDate.toInstant(ZoneOffset.UTC));

    @Column(name = "updatedAt")
    private Date updatedAt;

    public Enterprise() {
    }

    public Enterprise(long id, String name, String document, String phone, String address, List<Employee> users, List<Transaction> transactions) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.users = users;
        this.transactions = transactions;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        setUpdatedAt();
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        //setUpdatedAt();
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        //setUpdatedAt();
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        //setUpdatedAt();
        this.address = address;
    }

    public List<Employee> getUsers() {
        return users;
    }

    public void setUsers(List<Employee> users) {
        //setUpdatedAt();
        this.users = users;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        //setUpdatedAt();
        this.transactions = transactions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        LocalDateTime localDate = LocalDateTime.now(ZoneOffset.UTC);
        this.updatedAt = Date.from(localDate.toInstant(ZoneOffset.UTC));
    }


    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", users=" + users +
                ", transactions=" + transactions +
                ", createdAtTime=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
