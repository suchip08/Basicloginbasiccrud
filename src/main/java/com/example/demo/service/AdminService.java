package com.example.demo.service;

import com.example.demo.model.Admin;

public interface AdminService {
    Admin login(String username, String password);
    void save(Admin admin);
    java.util.List<Admin> findAll();
    Admin getById(Long id);
    void delete(Long id);
    org.springframework.data.domain.Page<Admin> findPaged(String q, int page, int size);
}
