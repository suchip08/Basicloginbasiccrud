package com.example.demo.service; // Package declaration

import org.springframework.beans.factory.annotation.Autowired; // Import Autowired
import org.springframework.stereotype.Service; // Import Service annotation
import com.example.demo.model.Admin; // Import Admin model
import com.example.demo.repository.AdminRepository; // Import AdminRepository
import java.util.List; // Import List

@Service // Marks this class as a Service component
public class AdminServiceImpl implements AdminService {

    @Autowired // Injects AdminRepository
    private AdminRepository repo;

    @Override
    public Admin login(String username, String password) {
        // Sanitize input
        String u = username == null ? "" : username.trim();
        String p = password == null ? "" : password.trim();
        
        // Try to find exact match
        Admin a = repo.findByUsernameIgnoreCaseAndPassword(u, p);
        if (a != null) return a;
        
        // Fallback: check username then password (manual check)
        Admin byU = repo.findByUsernameIgnoreCase(u);
        if (byU != null && byU.getPassword() != null && byU.getPassword().trim().equals(p)) {
            return byU;
        }
        return null; // Login failed
    }

    @Override
    public Admin save(Admin admin) {
        return repo.save(admin); // Save admin to DB
    }

    @Override
    public List<Admin> findAll() {
        return repo.findAll(); // Get all admins from DB
    }

    @Override
    public Admin getById(Long id) {
        return repo.findById(id).orElse(null); // Get admin by ID or null
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id); // Delete admin from DB
    }
}
