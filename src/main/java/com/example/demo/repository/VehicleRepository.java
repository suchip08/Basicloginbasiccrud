package com.example.demo.repository; // Package declaration

import com.example.demo.model.Vehicle; // Import Vehicle model
import org.springframework.data.jpa.repository.JpaRepository; // Import JpaRepository

// Repository interface for Vehicle entity
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // Inherits basic CRUD methods
}
