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
        return repo.findByUsernameAndPassword(username, password);
    }

    public void save(Admin admin) {
        repo.save(admin);
    }
}
