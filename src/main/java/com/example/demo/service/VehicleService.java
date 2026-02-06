package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.model.Vehicle;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleNo() == null || vehicle.getVehicleNo().trim().isEmpty()) {
            vehicle.setVehicleNo("none");
        }
        return vehicleRepository.save(vehicle);
    }

    public String deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
        return "Vehicle deleted successfully";
    }

    public org.springframework.data.domain.Page<Vehicle> findPaged(String q, int page, int size) {
        org.springframework.data.domain.Pageable pageable = org.springframework.data.domain.PageRequest.of(page, size);
        if (q != null && !q.trim().isEmpty()) {
            String s = q.trim();
            return vehicleRepository.findByOwnerNameContainingIgnoreCaseOrVehicleNoContainingIgnoreCase(s, s, pageable);
        }
        return vehicleRepository.findAll(pageable);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        Vehicle v = vehicleRepository.findById(id).orElse(null);
        if (v != null) {
            v.setType(vehicleDetails.getType());
            v.setOwnerName(vehicleDetails.getOwnerName());
            v.setOwnerNumber(vehicleDetails.getOwnerNumber());
            v.setOwnerEmail(vehicleDetails.getOwnerEmail());
            v.setVehicleNo(vehicleDetails.getVehicleNo());
            return vehicleRepository.save(v);
        }
        return null;
    }
}
