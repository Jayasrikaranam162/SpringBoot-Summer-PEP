package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.MaintenanceRequest;
import com.example.demo.service.MaintenanceRequestService;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceRequestController {

    private final MaintenanceRequestService maintenanceRequestService;

    public MaintenanceRequestController(MaintenanceRequestService maintenanceRequestService) {
        this.maintenanceRequestService = maintenanceRequestService;
    }

    @PostMapping("/asset/{assetId}/vendor/{vendorId}")
    public MaintenanceRequest createMaintenanceRequest(@PathVariable Long assetId,
                                                       @PathVariable Long vendorId,
                                                       @RequestBody MaintenanceRequest request) {
        return maintenanceRequestService.createMaintenanceRequest(assetId, vendorId, request);
    }

    @GetMapping
    public List<MaintenanceRequest> getAllMaintenanceRequests() {
        return maintenanceRequestService.getAllMaintenanceRequests();
    }

    @GetMapping("/{id}")
    public MaintenanceRequest getMaintenanceRequestById(@PathVariable Long id) {
        return maintenanceRequestService.getMaintenanceRequestById(id);
    }

    @PutMapping("/complete/{maintenanceId}")
    public MaintenanceRequest completeMaintenance(@PathVariable Long maintenanceId) {
        return maintenanceRequestService.completeMaintenance(maintenanceId);
    }

    @DeleteMapping("/{id}")
    public String deleteMaintenanceRequest(@PathVariable Long id) {
        maintenanceRequestService.deleteMaintenanceRequest(id);
        return "Maintenance request deleted successfully with id: " + id;
    }
}