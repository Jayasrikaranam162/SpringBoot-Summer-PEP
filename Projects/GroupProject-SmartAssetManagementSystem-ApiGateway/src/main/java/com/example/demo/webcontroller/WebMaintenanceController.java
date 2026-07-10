package com.example.demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.MaintenanceRequest;
import com.example.demo.service.AssetService;
import com.example.demo.service.MaintenanceRequestService;
import com.example.demo.service.VendorService;

@Controller
@RequestMapping("/ui/maintenance")
public class WebMaintenanceController {

    private final MaintenanceRequestService maintenanceRequestService;
    private final AssetService assetService;
    private final VendorService vendorService;

    public WebMaintenanceController(MaintenanceRequestService maintenanceRequestService,
                                    AssetService assetService,
                                    VendorService vendorService) {
        this.maintenanceRequestService = maintenanceRequestService;
        this.assetService = assetService;
        this.vendorService = vendorService;
    }

    @GetMapping
    public String listMaintenanceRequests(Model model) {
        model.addAttribute("requests", maintenanceRequestService.getAllMaintenanceRequests());
        return "maintenance/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("maintenance", new MaintenanceRequest());
        model.addAttribute("assets", assetService.getAllAssets());
        model.addAttribute("vendors", vendorService.getAllVendors());
        return "maintenance/add";
    }

    @PostMapping("/add")
    public String createMaintenanceRequest(
            @RequestParam Long assetId,
            @RequestParam Long vendorId,
            @ModelAttribute MaintenanceRequest maintenance,
            Model model) {

        try {
            maintenanceRequestService.createMaintenanceRequest(assetId, vendorId, maintenance);
        } catch (Exception e) {
            model.addAttribute("maintenance", maintenance);
            model.addAttribute("assets", assetService.getAllAssets());
            model.addAttribute("vendors", vendorService.getAllVendors());
            model.addAttribute("errorMessage", e.getMessage());
            return "maintenance/add";
        }

        return "redirect:/ui/maintenance";
    }

    @GetMapping("/complete/{id}")
    public String completeMaintenance(@PathVariable Long id, Model model) {

        try {
            maintenanceRequestService.completeMaintenance(id);
        } catch (Exception e) {
            model.addAttribute("requests", maintenanceRequestService.getAllMaintenanceRequests());
            model.addAttribute("errorMessage", e.getMessage());
            return "maintenance/list";
        }

        return "redirect:/ui/maintenance";
    }

    @GetMapping("/delete/{id}")
    public String deleteMaintenance(@PathVariable Long id) {
        maintenanceRequestService.deleteMaintenanceRequest(id);
        return "redirect:/ui/maintenance";
    }
}