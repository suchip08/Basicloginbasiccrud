package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * VehicleController manages web requests related to Vehicles.
 * It connects the web pages (JSP) with the backend service.
 * 
 * @Controller: Defines this class as a Spring MVC Controller.
 * @RequestMapping: Sets the base URL for all methods to "/vehicles".
 */
@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    /**
     * @Autowired: Injects the VehicleService so we can use its methods.
     */
    @Autowired
    private VehicleService service;

    /**
     * Shows the list of all vehicles.
     * URL: /vehicles
     * 
     * @param model: Used to pass the list of vehicles to the JSP.
     * @param session: Used to check if the admin is logged in.
     */
    @GetMapping
    public String list(Model model, jakarta.servlet.http.HttpSession session) {
        // Security Check: Only allow access if ADMIN_USERNAME is in the session
        if (session.getAttribute("ADMIN_USERNAME") == null) {
            return "redirect:/admin/login";
        }
        
        // Get all vehicles and add them to the model for the view
        model.addAttribute("vehicles", service.getAllVehicles());
        
        return "vehicleList"; // Render vehicleList.jsp
    }

    /**
     * Shows the form to add a new vehicle.
     * URL: /vehicles/add
     */
    @GetMapping("/add")
    public String addForm() {
        return "addVehicle"; // Render addVehicle.jsp
    }

    /**
     * Handles saving a new vehicle.
     * URL: /vehicles/save (POST)
     * 
     * @param vehicle: The vehicle data from the form.
     * @param source: A parameter to check if it's from "ADMIN" or "PUBLIC".
     */
    @PostMapping("/save")
    public String save(Vehicle vehicle, @RequestParam(required = false, defaultValue = "ADMIN") String source) {
        // Beginner Logic: Set a default type if none is provided
        if (vehicle.getType() == null || vehicle.getType().trim().isEmpty()) {
            vehicle.setType("none"); 
        }
        
        // Save the vehicle using the service
        service.saveVehicle(vehicle); 
        
        // Redirect logic: Public users go to success page, Admins go back to list
        if ("PUBLIC".equalsIgnoreCase(source)) {
            return "success";
        }
        return "redirect:/vehicles";
    }

    /**
     * Shows the edit form for a specific vehicle.
     * URL: /vehicles/edit/{id}
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        // Find vehicle by ID and add to model
        model.addAttribute("vehicle", service.getVehicleById(id)); 
        return "editVehicle"; // Render editVehicle.jsp
    }

    /**
     * Handles updating an existing vehicle.
     * URL: /vehicles/update (POST)
     */
    @PostMapping("/update")
    public String update(@RequestParam Long id, Vehicle details) {
        // Update the vehicle details via service
        service.updateVehicle(id, details); 
        return "redirect:/vehicles"; // Go back to the list
    }

    /**
     * Deletes a vehicle.
     * URL: /vehicles/delete/{id}
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteVehicle(id); // Delete the vehicle
        return "redirect:/vehicles"; // Go back to the list
    }
}
