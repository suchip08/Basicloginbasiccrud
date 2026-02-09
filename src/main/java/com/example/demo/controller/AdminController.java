package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        Model model) {
//
//        Admin admin = service.login(username, password);
//        if (admin != null) {
//            return "adminDashboard";
//        }
//
//        model.addAttribute("error", "Invalid username or password");
//        return "login";
//    }

    @GetMapping("/add")
    public String addAdminPage() {
        return "addAdmin";
    }

    @GetMapping("/list")
    public String listAdmins(Model model) {
        model.addAttribute("admins", service.findAll());
        return "adminList";
    }

    @GetMapping("/edit/{id}")
    public String editAdmin(@PathVariable Long id, Model model) {
        model.addAttribute("admin", service.getById(id));
        return "editAdmin";
    }

    @PostMapping("/save")
    public String saveAdmin(Admin admin, HttpSession session) {
        service.save(admin);
        return "redirect:/admin/login";
    }
    
    @PostMapping("/update")
    public String updateAdmin(Admin admin) {
        service.save(admin);
        return "redirect:/admin/list";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/admin/list";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("invalidNameCount", userService.getInvalidNameCount());
        return "adminDashboard"; // make sure adminDashboard.jsp exists
    }
    
    
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        Admin admin = service.login(username, password);
        if (admin != null) {
            session.setAttribute("ADMIN_USERNAME", username);
            session.setAttribute("ADMIN_ID", admin.getId());
            return "redirect:/admin/dashboard"; // ✅ redirect fixes 404
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

        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

}
