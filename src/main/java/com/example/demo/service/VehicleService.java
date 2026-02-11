package com.example.demo.service;

import com.example.demo.model.Vehicle;
import java.util.List;

/**
 * VehicleService Interface.
 * Defines the contract (methods) that the implementation must provide.
 * This helps in loose coupling and easier testing.
 */
public interface VehicleService {

    // Get all vehicles
    List<Vehicle> getAllVehicles();

    // Get a single vehicle by ID
    Vehicle getVehicleById(Long id);

    // Save a new vehicle
    Vehicle saveVehicle(Vehicle vehicle);

    // Delete a vehicle
    String deleteVehicle(Long id);

    // Update an existing vehicle
    Vehicle updateVehicle(Long id, Vehicle vehicleDetails);
}
