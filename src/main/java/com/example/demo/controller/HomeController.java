package com.example.demo.controller; // Package declaration

import org.springframework.stereotype.Controller; // Import Controller annotation
import org.springframework.web.bind.annotation.GetMapping; // Import GetMapping annotation

@Controller // Marks this class as a Spring MVC controller
public class HomeController {

    @GetMapping("/") // Maps the root URL ("/") to this method
    public String home() {
        // Redirects to the admin login page when accessing the home page
        return "login"; 
    }
}
