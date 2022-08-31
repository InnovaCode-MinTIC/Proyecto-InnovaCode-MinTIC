package com.innovacode.InnovaCode.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "document", nullable = false, length = 50)
    private String document;
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;
    @Column(name = "addres", nullable = false, length = 50)
    private String address;

    @OneToMany(mappedBy = "enterprise")
    List<Employee> employee;

    @OneToMany(mappedBy = "enterprise")
    List<Transaction> transactions;
    //private Transaction [] transactions;
    @Column(name = "createdAt", nullable = false, length = 50)
    private Date createdAt;
    @Column(name = "updatedAt", nullable = false, length = 50)
    private Date updatedAt;

    public Enterprise() {
    }

    public Enterprise(long id, String name, String document, String phone, String address) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        setCreatedAt();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
        setUpdatedAt();
    }

    public void setDocument(String document) {
        this.document = document;
        setUpdatedAt();
    }

    public void setPhone(String phone) {
        this.phone = phone;
        setUpdatedAt();
    }

    public void setAddress(String address) {
        this.address = address;
        setUpdatedAt();
    }

     public void setTransactions(Transaction[] transactions) {
        this.transactions = Arrays.asList(transactions);
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    @Override
    public String toString() {
        return  "Empresa{" +
                "\n\t nombre='" + name + '\'' +
                "\n\t direccion='" + address + '\'' +
                "\n\t telefono='" + phone + '\'' +
                "\n\t nit='" + document + '\'' +
                "\n\t created_at='" + createdAt + '\'' +
                "\n\t updated_at='" + updatedAt + '\'' +
                '}';
    }
}
