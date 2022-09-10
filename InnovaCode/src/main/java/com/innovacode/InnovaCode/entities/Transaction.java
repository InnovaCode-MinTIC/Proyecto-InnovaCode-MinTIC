package com.innovacode.InnovaCode.entities;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
@Entity
@Table(name ="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "concept")
    private String concept;

    @Column(name = "amount")
    private float amount;

    @ManyToOne
    private Enterprise enterprise;

    @ManyToOne
    private Employee employee;

    @Column(name ="createdAt")
    private Date createdAt;
    @Column(name="updatedAt")
    private Date updatedAt;

    public Transaction() {
    }

    public Transaction(long id, String concept, float amount, Enterprise enterprise, Employee employee) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.enterprise = enterprise;
        this.employee = employee;
        LocalDateTime localDate = LocalDateTime.now(ZoneOffset.UTC);
        this.createdAt = Date.from(localDate.toInstant(ZoneOffset.UTC));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        setUpdatedAt();
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        setUpdatedAt();
        this.amount = amount;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        setUpdatedAt();
        this.enterprise = enterprise;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        setUpdatedAt();
        this.employee = employee;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        LocalDateTime localDate = LocalDateTime.now(ZoneOffset.UTC);
        this.updatedAt = Date.from(localDate.toInstant(ZoneOffset.of("-05:00")));
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", concept='" + concept + '\'' +
                ", amount=" + amount +
                ", enterprise=" + enterprise +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
