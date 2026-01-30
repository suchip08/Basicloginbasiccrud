package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "userList";
    }

    @GetMapping("/add")
    public String addUserForm() {
        return "addUser";
    }

    @PostMapping("/save")
    public String saveUser(User user, @RequestParam String source) {

        if (user.getPhone() == null || user.getPhone().isBlank()) {
            user.setPhone("Not given phone number add by controlller");
        }

        service.saveUser(user);
        return "ADMIN".equals(source) ? "redirect:/users" : "success";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "editUser";
    }

//    @PostMapping("/update")
//    public String updateUser(User user) {
//        service.saveUser(user);
//        return "redirect:/users";
//    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "redirect:/users";
    }
    
    
    @PostMapping("/update")
    public String updateUser(User user) {
        service.saveUser(user);
        return "redirect:/admin/dashboard"; // redirect back to dashboard
    }

}
