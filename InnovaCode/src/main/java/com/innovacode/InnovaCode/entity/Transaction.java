package com.innovacode.InnovaCode.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 50)
    private long id;
    @Column(name = "concept", nullable = false, length = 50)
    private String concept;
    @Column(name = "amount", nullable = false, length = 50)
    private float amount;
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Enterprise enterprise;
    private Date createdAt;
    private Date updatedAt;

    public Transaction() {
    }

    public Transaction(long id, String concept, float amount, Profile user, Enterprise enterprise) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
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

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
                "\n\t user=" + employee +
                "\n\t enterprise=" + enterprise.getName() +
                "\n\t createdAt=" + createdAt +
                "\n\t updatedAt=" + updatedAt +
                '}';
    }
    
}
