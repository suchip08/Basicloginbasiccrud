package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import java.util.List;

/**
 * AdminServiceImpl contains the business logic for Admin authentication.
 * It implements the AdminService interface.
 * 
 * @Service: Spring Service component.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository repo;

    /**
     * Authenticates an admin by username and password.
     * 
     * @return: The Admin object if found, otherwise null.
     */
    @Override
    public Admin login(String username, String password) {
        // Clean up input (remove spaces, handle nulls)
        String u = username == null ? "" : username.trim();
        String p = password == null ? "" : password.trim();
        
        // Step 1: Try to find exact match in DB
        Admin a = repo.findByUsernameIgnoreCaseAndPassword(u, p);
        if (a != null) return a;
        
        // Step 2: Fallback manual check (sometimes needed if DB is case sensitive)
        Admin byU = repo.findByUsernameIgnoreCase(u);
        if (byU != null && byU.getPassword() != null && byU.getPassword().trim().equals(p)) {
            return byU;
        }
        
        return null; // Login failed
    }

    /**
     * Saves an admin to the database.
     */
    @Override
    public Admin save(Admin admin) {
        return repo.save(admin);
    }

    /**
     * Gets all admins.
     */
    @Override
    public List<Admin> findAll() {
        return repo.findAll();
    }

    /**
     * Gets an admin by ID.
     */
    @Override
    public Admin getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Deletes an admin by ID.
     */
    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
