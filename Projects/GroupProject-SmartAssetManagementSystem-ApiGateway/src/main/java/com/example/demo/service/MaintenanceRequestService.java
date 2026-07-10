package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.MaintenanceRequest;

public interface MaintenanceRequestService {

    MaintenanceRequest createMaintenanceRequest(Long assetId, Long vendorId, MaintenanceRequest request);

    List<MaintenanceRequest> getAllMaintenanceRequests();

    MaintenanceRequest getMaintenanceRequestById(Long id);

    MaintenanceRequest completeMaintenance(Long maintenanceId);

    void deleteMaintenanceRequest(Long id);
}