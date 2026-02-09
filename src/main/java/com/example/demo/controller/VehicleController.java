package com.example.demo.controller; // Package declaration

import com.example.demo.model.Vehicle; // Import Vehicle model
import com.example.demo.service.VehicleService; // Import VehicleService
import org.springframework.beans.factory.annotation.Autowired; // Import Autowired
import org.springframework.stereotype.Controller; // Import Controller
import org.springframework.ui.Model; // Import Model
import org.springframework.web.bind.annotation.*; // Import web annotations

@Controller // Marks this class as a web controller
@RequestMapping("/vehicles") // Base URL for vehicle-related actions
public class VehicleController {

    @Autowired // Injects the VehicleService
    private VehicleService service;

    @GetMapping // Maps GET requests to /vehicles
    public String list(Model model, jakarta.servlet.http.HttpSession session) {
        if (session.getAttribute("ADMIN_USERNAME") == null) { // Check for admin login
            return "redirect:/admin/login";
        }
        model.addAttribute("vehicles", service.getAllVehicles()); // Add vehicles to model
        return "vehicleList"; // Return list view
    }

    @GetMapping("/add") // Maps GET requests to /vehicles/add
    public String addForm() {
        return "addVehicle"; // Return add vehicle form
    }

    @PostMapping("/save") // Maps POST requests to /vehicles/save
    public String save(Vehicle vehicle, @RequestParam(required = false, defaultValue = "ADMIN") String source) {
        if (vehicle.getType() == null || vehicle.getType().trim().isEmpty()) {
            vehicle.setType("none"); // Default type if empty
        }
        service.saveVehicle(vehicle); // Save vehicle
        
        if ("PUBLIC".equalsIgnoreCase(source)) {
            return "success";
        }
        return "redirect:/vehicles"; // Redirect to list
    }

    @GetMapping("/edit/{id}") // Maps GET requests to /vehicles/edit/{id}
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("vehicle", service.getVehicleById(id)); // Fetch vehicle and add to model
        return "editVehicle"; // Return edit view
    }

    @PostMapping("/update") // Maps POST requests to /vehicles/update
    public String update(@RequestParam Long id, Vehicle details) {
        service.updateVehicle(id, details); // Update vehicle details
        return "redirect:/vehicles"; // Redirect to list
    }

    @GetMapping("/delete/{id}") // Maps GET requests to /vehicles/delete/{id}
    public String delete(@PathVariable Long id) {
        service.deleteVehicle(id); // Delete vehicle
        return "redirect:/vehicles"; // Redirect to list
    }
}
