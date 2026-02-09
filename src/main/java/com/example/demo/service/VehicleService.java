package com.example.demo.service; // Package declaration

import org.springframework.beans.factory.annotation.Autowired; // Import Autowired
import org.springframework.stereotype.Service; // Import Service annotation
import com.example.demo.repository.VehicleRepository; // Import VehicleRepository
import com.example.demo.model.Vehicle; // Import Vehicle model
import java.util.List; // Import List

@Service // Marks this class as a Service component
public class VehicleService {
    
    @Autowired // Injects VehicleRepository
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll(); // Get all vehicles
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null); // Get vehicle by ID
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        // Default value logic
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
        return vehicleRepository.save(vehicle); // Save vehicle
    }

    public String deleteVehicle(Long id) {
        vehicleRepository.deleteById(id); // Delete vehicle
        return "Vehicle deleted successfully";
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        // Fetch existing vehicle
        Vehicle v = vehicleRepository.findById(id).orElse(null);
        if (v != null) {
            // Update fields
            v.setType(vehicleDetails.getType());
            v.setOwnerName(vehicleDetails.getOwnerName());
            v.setOwnerNumber(vehicleDetails.getOwnerNumber());
            v.setOwnerEmail(vehicleDetails.getOwnerEmail());
            v.setVehicleNo(vehicleDetails.getVehicleNo());
            return vehicleRepository.save(v); // Save updated vehicle
        }
        return null;
    }
}
