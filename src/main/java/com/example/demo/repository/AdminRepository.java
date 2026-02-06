package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsernameAndPassword(String username, String password);
    Page<Admin> findByUsernameContainingIgnoreCase(String username, Pageable pageable);
    Admin findByUsernameIgnoreCaseAndPassword(String username, String password);
    Admin findByUsernameIgnoreCase(String username);
}
