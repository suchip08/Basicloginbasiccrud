package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String ownerNumber;

    @Column(nullable = false)
    private String ownerEmail;

    @Column(nullable = false)
    private String vehicleNo;

    @PrePersist
    void applyDefaults() {
        if (ownerEmail == null || ownerEmail.trim().isEmpty()) {
            ownerEmail = "none";
        }
    }

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
