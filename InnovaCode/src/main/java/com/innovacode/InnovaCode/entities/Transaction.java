package com.innovacode.InnovaCode.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
@Entity
@Table(name ="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String concept;
    private float amount;
    private Profile user;
    private Enterprise enterprise;
    private Date createdAt;
    private Date updatedAt;

    public Transaction() {
    }

    public Transaction(long id, String concept, float amount, Profile user, Enterprise enterprise) {
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

    public Profile getUser() {
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

    public void setUser(Profile user) {
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
    @Override
    public String toString() {
        return "Transaction{" +
                "\n\t id=" + id +
                "\n\t concept='" + concept + '\'' +
                "\n\t amount=" + amount +
                "\n\t user=" + user.getUser() +
                "\n\t enterprise=" + enterprise.getName() +
                "\n\t createdAt=" + createdAt +
                "\n\t updatedAt=" + updatedAt +
                '}';
    }
    
}
