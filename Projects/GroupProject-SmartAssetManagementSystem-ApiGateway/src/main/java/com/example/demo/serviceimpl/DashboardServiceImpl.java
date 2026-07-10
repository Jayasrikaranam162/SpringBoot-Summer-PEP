package com.example.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DashboardResponse;
import com.example.demo.repository.AssetAssignmentRepository;
import com.example.demo.repository.AssetCategoryRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DamageReportRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.MaintenanceRequestRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final AssetCategoryRepository assetCategoryRepository;
    private final VendorRepository vendorRepository;
    private final AssetRepository assetRepository;
    private final AssetAssignmentRepository assetAssignmentRepository;
    private final MaintenanceRequestRepository maintenanceRequestRepository;
    private final DamageReportRepository damageReportRepository;

    public DashboardServiceImpl(DepartmentRepository departmentRepository,
                                EmployeeRepository employeeRepository,
                                AssetCategoryRepository assetCategoryRepository,
                                VendorRepository vendorRepository,
                                AssetRepository assetRepository,
                                AssetAssignmentRepository assetAssignmentRepository,
                                MaintenanceRequestRepository maintenanceRequestRepository,
                                DamageReportRepository damageReportRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.assetCategoryRepository = assetCategoryRepository;
        this.vendorRepository = vendorRepository;
        this.assetRepository = assetRepository;
        this.assetAssignmentRepository = assetAssignmentRepository;
        this.maintenanceRequestRepository = maintenanceRequestRepository;
        this.damageReportRepository = damageReportRepository;
    }

    @Override
    public DashboardResponse getAdminDashboard() {

        DashboardResponse response = new DashboardResponse();

        response.setTotalDepartments(departmentRepository.count());
        response.setTotalEmployees(employeeRepository.count());
        response.setTotalCategories(assetCategoryRepository.count());
        response.setTotalVendors(vendorRepository.count());
        response.setTotalAssets(assetRepository.count());

        response.setAvailableAssets(assetRepository.countByAssetStatus("AVAILABLE"));
        response.setAssignedAssets(assetRepository.countByAssetStatus("ASSIGNED"));
        response.setUnderMaintenanceAssets(assetRepository.countByAssetStatus("UNDER_MAINTENANCE"));

        response.setDamagedAssets(assetRepository.countByConditionStatus("DAMAGED"));

        response.setTotalAssignments(assetAssignmentRepository.count());
        response.setTotalMaintenanceRequests(maintenanceRequestRepository.count());
        response.setTotalDamageReports(damageReportRepository.count());

        return response;
    }
}