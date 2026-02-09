package com.example.demo.model; // Package declaration

import jakarta.persistence.*; // Import JPA annotations

@Entity // Database entity
@Table(name = "vehicles") // Maps to 'vehicles' table
public class Vehicle {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    @Column(nullable = false) // Cannot be null
    private String type;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String ownerNumber;

    @Column(nullable = false)
    private String ownerEmail;

    @Column(nullable = false)
    private String vehicleNo;

    @PrePersist // Set defaults before saving
    void applyDefaults() {
        if (ownerEmail == null || ownerEmail.trim().isEmpty()) {
            ownerEmail = "none";
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getOwnerNumber() { return ownerNumber; }
    public void setOwnerNumber(String ownerNumber) { this.ownerNumber = ownerNumber; }

    public String getOwnerEmail() { return ownerEmail; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }

    public String getVehicleNo() { return vehicleNo; }
    public void setVehicleNo(String vehicleNo) { this.vehicleNo = vehicleNo; }
}
