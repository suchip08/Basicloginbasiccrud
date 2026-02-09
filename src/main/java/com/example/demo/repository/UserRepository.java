package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
    
    @Query(value = "SELECT COUNT(*) FROM users WHERE name REGEXP '[0-9]|[^A-Za-z0-9 ]'", nativeQuery = true) 
    long countUsersWhoseNameContainsNumberOrSpecial();
    
}
