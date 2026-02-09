package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address = "Address not added";

    @Column(nullable = false)
    private String adhar;

    @Column(nullable = false)
    private String panNo;

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    private Double height = 4.5;

    @Column(nullable = true)
    private String filledBy;

    @Column(nullable = true)
    private Long addedByAdminId;

    @PrePersist
    void applyModelDefaults() {
        if (address == null || address.trim().isEmpty()) {
            address = "Address not added";
        }
        if (adhar == null || adhar.trim().isEmpty()) {
            adhar = "not provide";
        }
        if (height == null || height <= 0) {
            height = 4.5;
        }
        if (filledBy == null || filledBy.trim().isEmpty()) {
            filledBy = "user";
        }
    }
    
 @Column(nullable = false)
   private String company="Company A#12";
               
    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getAdhar() { return adhar; }
    public void setAdhar(String adhar) { this.adhar = adhar; }

    public String getPanNo() { return panNo; }
    public void setPanNo(String panNo) { this.panNo = panNo; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }
    
    public String getFilledBy() { return filledBy; }
    public void setFilledBy(String filledBy) { this.filledBy = filledBy; }
    
    public Long getAddedByAdminId() { return addedByAdminId; }
    public void setAddedByAdminId(Long addedByAdminId) { this.addedByAdminId = addedByAdminId; }

    
}
