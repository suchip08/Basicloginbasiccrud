package com.example.demo.model; // Package declaration

import jakarta.persistence.*; // Import JPA annotations for database mapping

@Entity // Marks this class as a JPA entity (maps to a database table)
@Table(name = "admins") // Specifies the name of the table in the database
public class Admin {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures auto-increment for the ID
    private Long id;

    @Column(unique = true) // Ensures username is unique in the database
    private String username;

    private String password; // Stores the password

    @Column(nullable = true) // Allows this column to be null
    private String createdBy;

    @PrePersist // Runs this method before saving to the database
    void applyDefaults() {
        if (createdBy == null || createdBy.trim().isEmpty()) {
            createdBy = "admin"; // Default value if not provided
        }
    }
    
    // Getters and Setters
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
