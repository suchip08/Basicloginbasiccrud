package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.model.Vehicle;
import java.util.List;

/**
 * VehicleService handles business logic for Vehicles.
 * 
 * @Service: Tells Spring to manage this class as a Service bean.
 */
@Service
public class VehicleService {
    
    /**
     * @Autowired: Injects the VehicleRepository for database access.
     */
    @Autowired
    private VehicleRepository vehicleRepository;

    /**
     * Gets all vehicles from the database.
     */
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    /**
     * Finds a vehicle by its ID.
     */
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    /**
     * Saves a new vehicle to the database.
     * Adds default values for missing fields.
     */
    public Vehicle saveVehicle(Vehicle vehicle) {
        // --- Beginner Logic: Default Values ---
        
        if (vehicle.getVehicleNo() == null || vehicle.getVehicleNo().trim().isEmpty()) {
            vehicle.setVehicleNo("none");
        }
        if (vehicle.getOwnerName() == null || vehicle.getOwnerName().trim().isEmpty()) {
            vehicle.setOwnerName("Unknown Owner");
        }
        if (vehicle.getOwnerNumber() == null || vehicle.getOwnerNumber().trim().isEmpty()) {
            vehicle.setOwnerNumber("No Number");
        }
        if (vehicle.getOwnerEmail() == null || vehicle.getOwnerEmail().trim().isEmpty()) {
            vehicle.setOwnerEmail("none");
        }
        
        return vehicleRepository.save(vehicle);
    }

    /**
     * Deletes a vehicle by ID.
     */
    public String deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
        return "Vehicle deleted successfully";
    }

    /**
     * Updates an existing vehicle's details.
     */
    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        // Step 1: Find the existing vehicle
        Vehicle v = vehicleRepository.findById(id).orElse(null);
        
        // Step 2: If found, update its fields
        if (v != null) {
            v.setType(vehicleDetails.getType());
            v.setOwnerName(vehicleDetails.getOwnerName());
            v.setOwnerNumber(vehicleDetails.getOwnerNumber());
            v.setOwnerEmail(vehicleDetails.getOwnerEmail());
            v.setVehicleNo(vehicleDetails.getVehicleNo());
            
            // Step 3: Save the changes
            return vehicleRepository.save(v);
        }
        return null; // Return null if not found
    }
}
