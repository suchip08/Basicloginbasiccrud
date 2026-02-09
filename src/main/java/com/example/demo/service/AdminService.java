package com.example.demo.service; // Package declaration

import com.example.demo.model.Admin; // Import Admin model
import java.util.List; // Import List

public interface AdminService {
    Admin login(String username, String password); // Login method
    Admin save(Admin admin); // Save/Update admin
    List<Admin> findAll(); // Get all admins
    Admin getById(Long id); // Get admin by ID
    void delete(Long id); // Delete admin
}
