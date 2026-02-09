package com.example.demo.repository; // Package declaration

import org.springframework.data.jpa.repository.JpaRepository; // Import JpaRepository
import com.example.demo.model.User; // Import User model

// Repository interface for User entity
public interface UserRepository extends JpaRepository<User, Long> {
    // Inherits basic CRUD methods (save, findAll, findById, deleteById) from JpaRepository
}
