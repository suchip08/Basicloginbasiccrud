package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * AdminController manages Admin login and dashboard access.
 * 
 * @Controller: Spring web controller.
 * @RequestMapping: All URLs start with "/admin".
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * @Autowired: Injects the AdminService.
     */
    @Autowired
    private AdminService service;

    /**
     * Shows the login page.
     * URL: /admin/login
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Render login.jsp
    }

    /**
     * Shows the Admin Dashboard.
     * URL: /admin/dashboard
     */
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        // Security Check: Ensure user is logged in
        if (session.getAttribute("ADMIN_USERNAME") == null) {
            return "redirect:/admin/login";
        }
        return "adminDashboard"; // Render adminDashboard.jsp
    }
    
    /**
     * Handles the login form submission.
     * URL: /admin/login (POST)
     * 
     * @param username: Form field 'username'
     * @param password: Form field 'password'
     * @param model: To send error messages to the JSP
     * @param session: To store the logged-in user's state
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        // Step 1: Check credentials with the service
        Admin admin = service.login(username, password);
        
        // Step 2: If valid, save to session and go to dashboard
        if (admin != null) {
            session.setAttribute("ADMIN_USERNAME", username);
            session.setAttribute("ADMIN_ID", admin.getId());
            return "redirect:/admin/dashboard";
        }

        // --- Beginner Note: Auto-Create First Admin (Bootstrap) ---
        // If the database is empty, create the first admin with these credentials.
        // This prevents being locked out of a new system.
        java.util.List<Admin> existing = service.findAll();
        if (existing == null || existing.isEmpty()) {
            Admin first = new Admin();
            first.setUsername(username);
            first.setPassword(password);
            service.save(first);
            
            // Log them in immediately
            session.setAttribute("ADMIN_USERNAME", username);
            session.setAttribute("ADMIN_ID", first.getId());
            return "redirect:/admin/dashboard";
        }

        // Step 3: If login failed, show error
        model.addAttribute("error", "Invalid username or password");
        return "login"; // Go back to login page
    }

}
