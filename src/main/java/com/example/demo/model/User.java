package com.example.demo.model; // Package declaration

import jakarta.persistence.*; // Import JPA annotations

@Entity // Marks this class as a database entity
@Table(name = "users") // Maps this class to the 'users' table
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(nullable = false) // Column cannot be null
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address ;

    @Column(nullable = false)
    private String adhar;

    @Column(nullable = false)
    private String panNo;

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    private String height;
    
    @Column(nullable = false)
    private String company="Company A#12"; // Default value for company

    @Column(name = "filled_by")
    private String filledBy;

    @PrePersist // Runs before saving to DB to set defaults
    void applyModelDefaults() {
        if (address == null || address.trim().isEmpty()) {
            address = "Address not added";
        }
        if (adhar == null || adhar.trim().isEmpty()) {
            adhar = "not provide";
        }
        if (height == null || height.trim().isEmpty()) {
            height = "4.5";
        }
        if (filledBy == null || filledBy.trim().isEmpty()) {
            filledBy = "Self/Unknown";
        }
    }
    
    // Getters and Setters
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

    public String getHeight() { return height; }
    public void setHeight(String height) { this.height = height; }

    public String getFilledBy() { return filledBy; }
    public void setFilledBy(String filledBy) { this.filledBy = filledBy; }
}
