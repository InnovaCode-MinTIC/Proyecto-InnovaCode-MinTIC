package com.innovacode.InnovaCode.entity;


import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {


    public Employee() {
    }

    public enum Enum_RoleName {
        Admin, Operario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @OneToOne(mappedBy = "employee")
    private Profile profile;
    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Enum_RoleName role;
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Enterprise enterprise;
    @OneToMany(mappedBy = "employee")
    List<Transaction> transactions;
    @Column(name = "createdAt")
        private Date createdAt;
    @Column(name = "updatedAt")
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setId(long id) {
        this.id = id;
        profile.setId(id+"");
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
        return "\n Employee{" +
                "\n id=" + id +
                "\n email='" + email + '\'' +
                "\n profile=" + profile +
                "\n role=" + role +
                "\n enterprise=" + enterprise +
                "\n transactions=" + Arrays.toString(new List[]{transactions}) +
                "\n createdAt=" + createdAt +
                "\n updatedAt=" + updatedAt +
                '}'+"\n";
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
