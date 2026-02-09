package com.example.demo.controller; // Defines the package for this class

import com.example.demo.model.Admin; // Imports the Admin model class
import com.example.demo.service.AdminService; // Imports the AdminService interface
import jakarta.servlet.http.HttpSession; // Imports HttpSession for managing user sessions
import org.springframework.beans.factory.annotation.Autowired; // Imports Autowired annotation for dependency injection
import org.springframework.stereotype.Controller; // Imports Controller annotation
import org.springframework.ui.Model; // Imports Model interface to pass data to views
import org.springframework.web.bind.annotation.*; // Imports Spring Web annotations (GetMapping, PostMapping, etc.)

@Controller // Marks this class as a Spring MVC Controller to handle web requests
@RequestMapping("/admin") // Base URL for all methods in this controller (e.g., /admin/login)
public class AdminController {

    @Autowired // Automatically injects an instance of AdminService
    private AdminService service;

    @GetMapping("/login") // Maps GET requests to /admin/login
    public String loginPage() {
        return "login"; // Returns the "login.jsp" view
    }

    @GetMapping("/add") // Maps GET requests to /admin/add
    public String addAdminPage() {
        return "addAdmin"; // Returns the "addAdmin.jsp" view
    }

    @GetMapping("/list") // Maps GET requests to /admin/list
    public String listAdmins(Model model, HttpSession session) {
        // Check if admin is logged in by checking the session
        if (session.getAttribute("ADMIN_USERNAME") == null) {
            return "redirect:/admin/login"; // Redirect to login if not authenticated
        }
        model.addAttribute("admins", service.findAll()); // Add list of admins to the model
        return "adminList"; // Returns "adminList.jsp"
    }

    @GetMapping("/edit/{id}") // Maps GET requests to /admin/edit/{id}
    public String editAdmin(@PathVariable Long id, Model model) { // @PathVariable extracts id from URL
        model.addAttribute("admin", service.getById(id)); // Fetch admin by ID and add to model
        return "editAdmin"; // Returns "editAdmin.jsp"
    }

    @PostMapping("/save") // Maps POST requests to /admin/save
    public String saveAdmin(Admin admin, HttpSession session) {
        service.save(admin); // Save the admin using the service
        return "redirect:/admin/login"; // Redirect to login page after saving
    }
    
    @PostMapping("/update") // Maps POST requests to /admin/update
    public String updateAdmin(Admin admin) {
        service.save(admin); // Updates the admin (save handles both create and update)
        return "redirect:/admin/list"; // Redirect to the admin list
    }
    
    @GetMapping("/delete/{id}") // Maps GET requests to /admin/delete/{id}
    public String deleteAdmin(@PathVariable Long id) {
        service.delete(id); // Deletes the admin by ID
        return "redirect:/admin/list"; // Redirect back to list
    }
    
    @GetMapping("/dashboard") // Maps GET requests to /admin/dashboard
    public String dashboard(Model model, HttpSession session) {
        if (session.getAttribute("ADMIN_USERNAME") == null) { // Security check
            return "redirect:/admin/login";
        }
        return "adminDashboard"; // Returns "adminDashboard.jsp"
    }
    
    
    @PostMapping("/login") // Maps POST requests to /admin/login (form submission)
    public String login(@RequestParam String username, // @RequestParam extracts form data
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        Admin admin = service.login(username, password); // Authenticate admin
        if (admin != null) {
            session.setAttribute("ADMIN_USERNAME", username); // Store username in session
            session.setAttribute("ADMIN_ID", admin.getId()); // Store ID in session
            return "redirect:/admin/dashboard"; // Redirect to dashboard on success
        }

        // Bootstrap: if no admins exist, create the first one using provided credentials
        java.util.List<Admin> existing = service.findAll();
        if (existing == null || existing.isEmpty()) {
            Admin first = new Admin();
            first.setUsername(username);
            first.setPassword(password);
            service.save(first);
            session.setAttribute("ADMIN_USERNAME", username);
            session.setAttribute("ADMIN_ID", first.getId());
            return "redirect:/admin/dashboard";
        }

        model.addAttribute("error", "Invalid username or password"); // Add error message to model
        return "login"; // Return to login page on failure
    }

}
