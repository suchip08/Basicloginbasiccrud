package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping
    public String list(Model model,
                       @RequestParam(defaultValue = "") String q,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "10") int size) {
        org.springframework.data.domain.Page<Vehicle> p = service.findPaged(q, page, size);
        model.addAttribute("vehicles", p.getContent());
        model.addAttribute("page", page);
        model.addAttribute("totalPages", p.getTotalPages());
        model.addAttribute("q", q);
        model.addAttribute("size", size);
        return "vehicleList";
    }

    @GetMapping("/add")
    public String addForm() {
        return "addVehicle";
    }

    @PostMapping("/save")
    public String save(Vehicle vehicle) {
        if (vehicle.getType() == null || vehicle.getType().trim().isEmpty()) {
            vehicle.setType("none");
        }
        service.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("vehicle", service.getVehicleById(id));
        return "editVehicle";
    }

    @PostMapping("/update")
    public String update(@RequestParam Long id, Vehicle details) {
        service.updateVehicle(id, details);
        return "redirect:/vehicles";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteVehicle(id);
        return "redirect:/vehicles";
    }
}
