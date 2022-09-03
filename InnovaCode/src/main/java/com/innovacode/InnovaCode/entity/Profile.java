package com.innovacode.InnovaCode.entity;
import javax.persistence.*;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 50)
    private String id;
    @Column(name = "image", nullable = false, length = 150)
    private String image;
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Employee employee;
    @Column(name = "createdAt", nullable = false, length = 50)
    private Date createdAt;
    @Column(name = "updatedAt", nullable = false, length = 50)
    private Date updatedAt;

    public Profile() {
    }

    public Profile(String id, String image, String phone, Employee employee) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.employee = employee;
        setCreatedAt();
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Profile{" +
                "\n\t id='" + id + '\'' +
                "\n\t image='" + image + '\'' +
                "\n\t phone='" + phone + '\'' +
                "\n\t employee='" + employee + '\'' +
                "\n\t createdAt=" + createdAt +
                "\n\t updatedAt=" + updatedAt +
                '}';
    }

    public void setImage(String image) {
        this.image = image;
        setUpdatedAt();
    }

    public void setPhone(String phone) {
        this.phone = phone;
        setUpdatedAt();
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }
}
