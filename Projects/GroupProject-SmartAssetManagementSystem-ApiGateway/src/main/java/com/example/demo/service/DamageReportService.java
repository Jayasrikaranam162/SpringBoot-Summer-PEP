package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.DamageReport;

public interface DamageReportService {

    DamageReport createDamageReport(Long assetId, Long employeeId, DamageReport damageReport);

    List<DamageReport> getAllDamageReports();

    DamageReport getDamageReportById(Long id);

    DamageReport updateReportStatus(Long id, String status, String adminRemarks);

    void deleteDamageReport(Long id);
}