package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DamageReport;
import com.example.demo.service.DamageReportService;

@RestController
@RequestMapping("/api/damage-reports")
public class DamageReportController {

    private final DamageReportService damageReportService;

    public DamageReportController(DamageReportService damageReportService) {
        this.damageReportService = damageReportService;
    }

    @PostMapping("/asset/{assetId}/employee/{employeeId}")
    public DamageReport createDamageReport(@PathVariable Long assetId,
                                           @PathVariable Long employeeId,
                                           @RequestBody DamageReport damageReport) {
        return damageReportService.createDamageReport(assetId, employeeId, damageReport);
    }

    @GetMapping
    public List<DamageReport> getAllDamageReports() {
        return damageReportService.getAllDamageReports();
    }

    @GetMapping("/{id}")
    public DamageReport getDamageReportById(@PathVariable Long id) {
        return damageReportService.getDamageReportById(id);
    }

    @PutMapping("/{id}/status")
    public DamageReport updateReportStatus(@PathVariable Long id,
                                           @RequestParam String status,
                                           @RequestParam String adminRemarks) {
        return damageReportService.updateReportStatus(id, status, adminRemarks);
    }

    @DeleteMapping("/{id}")
    public String deleteDamageReport(@PathVariable Long id) {
        damageReportService.deleteDamageReport(id);
        return "Damage report deleted successfully with id: " + id;
    }
}