package com.example.demo.controller; // Package declaration

import com.example.demo.model.User; // Import User model
import com.example.demo.service.UserService; // Import UserService
import jakarta.servlet.http.HttpSession; // Import HttpSession for session management
import org.springframework.beans.factory.annotation.Autowired; // Import Autowired for dependency injection
import org.springframework.stereotype.Controller; // Import Controller annotation
import org.springframework.ui.Model; // Import Model to pass data to views
import org.springframework.web.bind.annotation.*; // Import web annotations

@Controller // Marks this class as a web controller
@RequestMapping("/users") // Base URL for user-related actions
public class UserController {

    @Autowired // Injects the UserService bean
    private UserService service;
    
    @GetMapping // Maps GET requests to /users (root of this controller)
    public String listUsers(Model model, HttpSession session) {
        if (session.getAttribute("ADMIN_USERNAME") == null) { // Check if admin is logged in
            return "redirect:/admin/login"; // Redirect if not logged in
        }
        model.addAttribute("users", service.getAllUsers()); // Add all users to the model
        return "userList"; // Return the user list view
    }

    @GetMapping("/add") // Maps GET requests to /users/add
    public String addUserForm() {
        return "addUser"; // Return the add user form view
    }

    @PostMapping("/save") // Maps POST requests to /users/save
    public String saveUser(User user, @RequestParam String source, HttpSession session) {

        // Basic validation and default values
        if (user.getPhone() == null || user.getPhone().isBlank()) {
            user.setPhone("Not given phone number add by controlller");
        }
        if (user.getAge() == null || user.getAge().isBlank()) {
            user.setAge("not provide age");
        }
        
        // Set filledBy based on source
        if ("ADMIN".equals(source)) {
            String adminUser = (String) session.getAttribute("ADMIN_USERNAME");
            user.setFilledBy("Added by Admin: " + (adminUser != null ? adminUser : "Unknown"));
        } else {
            user.setFilledBy("Public User");
        }
 
        service.saveUser(user); // Save the user to database
        return "ADMIN".equals(source) ? "redirect:/users" : "success"; // Redirect based on source
    }

    @GetMapping("/edit/{id}") // Maps GET requests to /users/edit/{id}
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.getUserById(id)); // Fetch user and add to model
        return "editUser"; // Return edit view
    }

    @GetMapping("/delete/{id}") // Maps GET requests to /users/delete/{id}
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id); // Delete user
        return "redirect:/users"; // Redirect to list
    }
    
    
    @PostMapping("/update") // Maps POST requests to /users/update
    public String updateUser(User user) {
        if (user.getAge() == null || user.getAge().isBlank()) {
            user.setAge("not provide age"); // Default value for age
        }
        
        // Preserve existing filledBy if possible, or set default
        User existing = service.getUserById(user.getId());
        if (existing != null) {
            user.setFilledBy(existing.getFilledBy());
        } else {
            user.setFilledBy("Unknown (Edit)");
        }
        
        service.saveUser(user); // Save/Update user
        return "redirect:/users"; // Redirect to list
    }

}
