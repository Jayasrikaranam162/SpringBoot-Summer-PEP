package com.example.demo.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Asset;
import com.example.demo.entity.MaintenanceRequest;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.MaintenanceRequestRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.MaintenanceRequestService;

@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService {

    private final MaintenanceRequestRepository maintenanceRequestRepository;
    private final AssetRepository assetRepository;
    private final VendorRepository vendorRepository;

    public MaintenanceRequestServiceImpl(MaintenanceRequestRepository maintenanceRequestRepository,
                                         AssetRepository assetRepository,
                                         VendorRepository vendorRepository) {
        this.maintenanceRequestRepository = maintenanceRequestRepository;
        this.assetRepository = assetRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public MaintenanceRequest createMaintenanceRequest(Long assetId, Long vendorId, MaintenanceRequest request) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + assetId));

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + vendorId));

        asset.setAssetStatus("UNDER_MAINTENANCE");
        asset.setConditionStatus("NEEDS_REPAIR");
        asset.setUpdatedAt(LocalDateTime.now());

        request.setAsset(asset);
        request.setVendor(vendor);
        request.setStartDate(LocalDate.now());
        request.setMaintenanceStatus("IN_PROGRESS");
        request.setCreatedAt(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());

        assetRepository.save(asset);

        return maintenanceRequestRepository.save(request);
    }

    @Override
    public List<MaintenanceRequest> getAllMaintenanceRequests() {
        return maintenanceRequestRepository.findAll();
    }

    @Override
    public MaintenanceRequest getMaintenanceRequestById(Long id) {
        return maintenanceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance request not found with id: " + id));
    }

    @Override
    public MaintenanceRequest completeMaintenance(Long maintenanceId) {

        MaintenanceRequest request = getMaintenanceRequestById(maintenanceId);

        Asset asset = request.getAsset();

        request.setMaintenanceStatus("COMPLETED");
        request.setEndDate(LocalDate.now());
        request.setUpdatedAt(LocalDateTime.now());

        asset.setAssetStatus("AVAILABLE");
        asset.setConditionStatus("GOOD");
        asset.setUpdatedAt(LocalDateTime.now());

        assetRepository.save(asset);

        return maintenanceRequestRepository.save(request);
    }

    @Override
    public void deleteMaintenanceRequest(Long id) {
        MaintenanceRequest request = getMaintenanceRequestById(id);
        maintenanceRequestRepository.delete(request);
    }
}