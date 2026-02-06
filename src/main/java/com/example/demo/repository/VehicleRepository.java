package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Page<Vehicle> findByOwnerNameContainingIgnoreCaseOrVehicleNoContainingIgnoreCase(String ownerName, String vehicleNo, Pageable pageable);
}
