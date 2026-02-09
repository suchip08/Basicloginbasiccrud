package com.example.demo.repository; // Package declaration

import org.springframework.data.jpa.repository.JpaRepository; // Import JpaRepository
import com.example.demo.model.Admin; // Import Admin model

// Repository interface for Admin entity, extends JpaRepository for CRUD operations
public interface AdminRepository extends JpaRepository<Admin, Long> {
    
    // Custom query method to find admin by username and password
    Admin findByUsernameAndPassword(String username, String password);
    
    // Custom query method (case insensitive)
    Admin findByUsernameIgnoreCaseAndPassword(String username, String password);
    
    // Find by username only
    Admin findByUsernameIgnoreCase(String username);
}
