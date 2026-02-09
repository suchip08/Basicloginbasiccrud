package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
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
    public String saveUser(User user, @RequestParam String source, HttpSession session) {

        if (user.getPhone() == null || user.getPhone().isBlank()) {
            user.setPhone("Not given phone number add by controlller");
        }
        if (user.getAge() == null || user.getAge().isBlank()) {
            user.setAge("not provide age");
        }
//        if ("ADMIN".equals(source)) {
//            String adminUser = (String) session.getAttribute("ADMIN_USERNAME");
//            Long adminId = (Long) session.getAttribute("ADMIN_ID");
//            if (adminUser != null && !adminUser.isBlank()) {
//                user.setFilledBy("added by admin (" + adminUser + ")");
//            } else {
//                user.setFilledBy("added by admin");
//            }
//            if (adminId != null) {
//                user.setAddedByAdminId(adminId);
//            }
//        } else {
//            user.setFilledBy("filled by self");
//        }

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
        if (user.getAge() == null || user.getAge().isBlank()) {
            user.setAge("not provide age");
        }
        
        // Preserve read-only fields for update
        User existing = service.getUserById(user.getId());
        if (existing != null) {
            // Restore fields that are not in the form but required by DB
            // 'company' has a default in class, but if we create new object it has default.
            // If existing record has different value, we might want to keep it?
            // Actually 'company' is hardcoded in class to "Company A#12", so new object has it.
            // But if we want to be safe:
            // user.setCompany(existing.getCompany()); // if getter exists
             if (user.getFilledBy() == null) user.setFilledBy(existing.getFilledBy());
             if (user.getAddedByAdminId() == null) user.setAddedByAdminId(existing.getAddedByAdminId());
        }

        service.saveUser(user);
        return "redirect:/users";
    }

}
