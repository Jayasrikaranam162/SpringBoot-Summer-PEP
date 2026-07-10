package com.example.demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ui/vendors")
public class WebVendorController {

    private final VendorService vendorService;

    public WebVendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public String listVendors(Model model) {
        model.addAttribute("vendors", vendorService.getAllVendors());
        return "vendor/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "vendor/add";
    }

    @PostMapping("/add")
    public String addVendor(
            @Valid @ModelAttribute("vendor") Vendor vendor,
            BindingResult result) {

        if (result.hasErrors()) {
            return "vendor/add";
        }

        vendorService.createVendor(vendor);
        return "redirect:/ui/vendors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("vendor", vendorService.getVendorById(id));
        return "vendor/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateVendor(
            @PathVariable Long id,
            @Valid @ModelAttribute("vendor") Vendor vendor,
            BindingResult result) {

        if (result.hasErrors()) {
            return "vendor/edit";
        }

        vendorService.updateVendor(id, vendor);
        return "redirect:/ui/vendors";
    }

    @GetMapping("/delete/{id}")
    public String deleteVendor(@PathVariable Long id, Model model) {

        try {
            vendorService.deleteVendor(id);
        } catch (Exception e) {
            model.addAttribute("vendors", vendorService.getAllVendors());
            model.addAttribute("errorMessage", "Cannot delete this vendor because assets are linked to it.");
            return "vendor/list";
        }

        return "redirect:/ui/vendors";
    }
}