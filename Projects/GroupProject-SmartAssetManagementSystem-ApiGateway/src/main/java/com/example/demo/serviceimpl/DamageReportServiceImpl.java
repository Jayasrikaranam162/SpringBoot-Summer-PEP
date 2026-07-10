package com.example.demo.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DamageReport;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DamageReportRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.DamageReportService;

@Service
public class DamageReportServiceImpl implements DamageReportService {

    private final DamageReportRepository damageReportRepository;
    private final AssetRepository assetRepository;
    private final EmployeeRepository employeeRepository;

    public DamageReportServiceImpl(DamageReportRepository damageReportRepository,
                                   AssetRepository assetRepository,
                                   EmployeeRepository employeeRepository) {
        this.damageReportRepository = damageReportRepository;
        this.assetRepository = assetRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DamageReport createDamageReport(Long assetId, Long employeeId, DamageReport damageReport) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + assetId));

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        asset.setConditionStatus("DAMAGED");
        asset.setUpdatedAt(LocalDateTime.now());

        damageReport.setAsset(asset);
        damageReport.setEmployee(employee);
        damageReport.setDamageDate(LocalDate.now());
        damageReport.setReportStatus("PENDING");
        damageReport.setCreatedAt(LocalDateTime.now());
        damageReport.setUpdatedAt(LocalDateTime.now());

        assetRepository.save(asset);

        return damageReportRepository.save(damageReport);
    }

    @Override
    public List<DamageReport> getAllDamageReports() {
        return damageReportRepository.findAll();
    }

    @Override
    public DamageReport getDamageReportById(Long id) {
        return damageReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Damage report not found with id: " + id));
    }

    @Override
    public DamageReport updateReportStatus(Long id, String status, String adminRemarks) {

        DamageReport report = getDamageReportById(id);

        report.setReportStatus(status);
        report.setAdminRemarks(adminRemarks);
        report.setUpdatedAt(LocalDateTime.now());

        if ("RESOLVED".equalsIgnoreCase(status)) {
            Asset asset = report.getAsset();
            asset.setConditionStatus("GOOD");
            asset.setUpdatedAt(LocalDateTime.now());
            assetRepository.save(asset);
        }

        return damageReportRepository.save(report);
    }

    @Override
    public void deleteDamageReport(Long id) {
        DamageReport report = getDamageReportById(id);
        damageReportRepository.delete(report);
    }
}