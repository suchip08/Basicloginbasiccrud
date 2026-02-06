package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository repo;

    public Admin login(String username, String password) {
        String u = username == null ? "" : username.trim();
        String p = password == null ? "" : password.trim();
        Admin a = repo.findByUsernameIgnoreCaseAndPassword(u, p);
        if (a != null) return a;
        Admin byU = repo.findByUsernameIgnoreCase(u);
        if (byU != null && byU.getPassword() != null && byU.getPassword().trim().equals(p)) {
            return byU;
        }
        return null;
    }

    public void save(Admin admin) {
        repo.save(admin);
    }

    public java.util.List<Admin> findAll() {
        return repo.findAll();
    }

    public Admin getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public org.springframework.data.domain.Page<Admin> findPaged(String q, int page, int size) {
        org.springframework.data.domain.Pageable pageable = org.springframework.data.domain.PageRequest.of(page, size);
        if (q != null && !q.trim().isEmpty()) {
            return repo.findByUsernameContainingIgnoreCase(q.trim(), pageable);
        }
        return repo.findAll(pageable);
    }
}
