package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MUST NOT BE NULL
    @Column(nullable = false)
    private String name;

    // Default set in CONTROLLER
    @Column(nullable = false)
    private String phone;

    // Default set in SERVICE
    @Column(nullable = false)
    private String email;

    // Default set in MODEL
    @Column(nullable = false)
    private String address = "Address not added";

    // ⭐ MODEL DEFAULT LOGIC
    @PrePersist
    void applyModelDefaults() {
        if (address == null || address.trim().isEmpty()) {
            address = "Address not added";
        }
    }
    
    // add in the model defalut
 @Column(nullable = false)
   private String company="Compnay A#12";
               
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
    
    

    
}
