package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * UserController handles all web requests related to Users.
 * It acts as a bridge between the View (JSP pages) and the Service layer.
 * 
 * Annotations used:
 * @Controller: Tells Spring this class is a Web Controller.
 * @RequestMapping: Defines the base URL for all methods in this class (e.g., /users).
 */
@Controller
@RequestMapping("/users")
public class UserController {

    /**
     * @Autowired: Spring automatically injects the UserService instance here.
     * We don't need to create it manually using 'new UserService()'.
     */
    @Autowired
    private UserService service;
    
    /**
     * Displays the list of all users.
     * URL: /users
     * 
     * @param model: Used to pass data from Controller to View (JSP).
     * @param session: Used to check if the admin is logged in.
     * @return: The name of the JSP file to render ("userList" or "login").
     */
    @GetMapping
    public String listUsers(Model model, HttpSession session) {
        // Security Check: Ensure only logged-in admins can see the list
        if (session.getAttribute("ADMIN_USERNAME") == null) {
            return "redirect:/admin/login"; // Redirect to login page if not logged in
        }
        
        // Fetch all users from service and add them to the model
        model.addAttribute("users", service.getAllUsers());
        
        return "userList"; // Opens userList.jsp
    }

    /**
     * Shows the form to add a new user.
     * URL: /users/add
     */
    @GetMapping("/add")
    public String addUserForm() {
        return "addUser"; // Opens addUser.jsp
    }

    /**
     * Handles the form submission to save a new user.
     * URL: /users/save (POST request)
     * 
     * @param user: Spring automatically maps form fields to this User object.
     * @param source: A hidden field in the form to know if it's from ADMIN or PUBLIC page.
     * @param session: Used to check session attributes if needed.
     */
    @PostMapping("/save")
    public String saveUser(User user, @RequestParam String source, HttpSession session) {
        
        // --- Beginner Note: Simple Validation Logic ---
        // If the user didn't provide an age, set a default message.
        if (user.getAge() == null || user.getAge().isBlank()) {
            user.setAge("not provide age");
        }

        // If the user didn't provide a phone number, set a default message.
        if (user.getPhone() == null || user.getPhone().isBlank()) {
            user.setPhone("Not given phone number");
        }

        // Call the service to save the user to the database
        service.saveUser(user);
        
        // Logic: If Admin added the user, go back to the list.
        // If a Public user added themselves, show a success page.
        if ("ADMIN".equals(source)) {
            return "redirect:/users";
        } else {
            return "success"; // Opens success.jsp
        }
    }

    /**
     * Shows the form to edit an existing user.
     * URL: /users/edit/{id} (e.g., /users/edit/5)
     * 
     * @param id: The ID from the URL path.
     * @param model: Used to send the existing user data to the form.
     */
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        // Find the user by ID and send it to the view
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "editUser"; // Opens editUser.jsp
    }

    /**
     * Deletes a user by ID.
     * URL: /users/delete/{id}
     */
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id); // Call service to delete
        return "redirect:/users"; // Redirect back to the list
    }
    
    /**
     * Handles the update form submission.
     * URL: /users/update (POST request)
     */
    @PostMapping("/update")
    public String updateUser(User user) {
        // Simple check for age
        if (user.getAge() == null || user.getAge().isBlank()) {
            user.setAge("not provide age"); 
        }
        
        // Update the user details in the database
        service.updateUser(user.getId(), user);
        
        return "redirect:/users"; // Go back to the list
    }

}
