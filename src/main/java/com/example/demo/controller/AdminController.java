package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

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

    @PostMapping("/save")
    public String saveAdmin(Admin admin) {
        service.save(admin);
        return "redirect:/admin/login";
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "adminDashboard"; // make sure adminDashboard.jsp exists
    }
    
    
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        Admin admin = service.login(username, password);
        if (admin != null) {
            return "redirect:/admin/dashboard"; // ✅ redirect fixes 404
        }

        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

}
