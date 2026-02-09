package com.example.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        // Print full stack trace to server console so we can see it in logs
        e.printStackTrace();
        
        // Pass error message to view
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("errorType", e.getClass().getSimpleName());
        
        return "error"; // We need to create error.jsp
    }
}
