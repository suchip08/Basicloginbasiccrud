package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

///**
// * UserService contains the business logic for User operations.
// * It sits between the Controller and the Repository (Database).
// * 
// * @Service: Marks this class as a Service component in Spring.
// */
@Service
public class UserService {

    /**
     * @Autowired: Injects the UserRepository to interact with the database.
     */
    @Autowired
    private UserRepository repo;

    /**
     * Saves a new user to the database.
     * Includes basic business logic to handle missing values.
     * 
     * @param user: The user object to save.
     * @return: The saved user object.
     */
    public User saveUser(User users) {
        // --- Business Logic: Default Values ---
        
        // If email is missing, set a placeholder
        if (users.getEmail() == null || users.getEmail().isBlank()) {
            users.setEmail("Email not provided");
        }
        
        // If PAN number is missing, set a placeholder
        if (users.getPanNo() == null || users.getPanNo().isBlank()) {
            users.setPanNo("not given");
        }
        
        // If Phone is missing, set a placeholder
        if (users.getPhone() == null || users.getPhone().isBlank()) {
            users.setPhone("Not provided");
           
        }
        
        // Use the repository to save the data to the database table
        return repo.save(users);
    }

    /**
     * Retrieves all users from the database.
     * @return: A List of all User objects.
     */
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    /**
     * Finds a single user by their ID.
     * @param id: The ID of the user.
     * @return: The User object, or null if not found.
     */
    public User getUserById(Long id) {
        // .orElse(null) means if no user is found, return null instead of throwing an error
        return repo.findById(id).orElse(null);
    }

    /**
     * Updates an existing user's details.
     * 
     * @param id: The ID of the user to update.
     * @param userDetails: The new data from the form.
     * @return: The updated user, or null if the user didn't exist.
     */
    public User updateUser(Long id, User userDetails) {
        // Step 1: Find the existing user in the database
        User existing = repo.findById(id).orElse(null);
        
        // Step 2: If found, update the fields
        if (existing != null) {
            existing.setName(userDetails.getName());
            existing.setPhone(userDetails.getPhone());
            existing.setEmail(userDetails.getEmail());
            existing.setAddress(userDetails.getAddress());
            existing.setAdhar(userDetails.getAdhar());
            existing.setPanNo(userDetails.getPanNo());
            existing.setAge(userDetails.getAge());
            existing.setHeight(userDetails.getHeight());
            
            // Step 3: Save the updated object back to the database
            return repo.save(existing);
        }
        
        return null; // Return null if user was not found
    }

    /**
     * Deletes a user from the database.
     * @param id: The ID of the user to delete.
     */
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}
