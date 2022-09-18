package com.innovacode.InnovaCode.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.innovacode.InnovaCode.enums.Enum_RoleName;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    LocalDateTime localDate = LocalDateTime.now(ZoneOffset.UTC);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "email",unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Enum_RoleName role;

    @ManyToOne
    private Enterprise enterprise;
    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Transaction> transactions;
    @Column(name = "image")
    private String image;
    @Column(name = "phone")
    private String phone;
    @Column(name = "createdAt")
    private Date createdAt = Date.from(localDate.toInstant(ZoneOffset.UTC));
    @Column(name = "updatedAt")
    private Date updatedAt;

    public Employee() {
    }

    public Employee(long id, String email, Enum_RoleName role, String image, String phone, Enterprise enterprise, List<Transaction> transactions) {
        this.id = id;
        this.email = email;
        this.image = image;
        this.phone = phone;
        this.role = role;
        this.enterprise = enterprise;
        this.transactions = transactions;
        this.createdAt = createdAt;
        this.updatedAt = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        setUpdatedAt();
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        //setUpdatedAt();
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        //setUpdatedAt();
        this.phone = phone;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        //setUpdatedAt();
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        //setUpdatedAt();
        this.enterprise = enterprise;
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
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", enterprise=" + enterprise +
                ", transactions=" + transactions +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
