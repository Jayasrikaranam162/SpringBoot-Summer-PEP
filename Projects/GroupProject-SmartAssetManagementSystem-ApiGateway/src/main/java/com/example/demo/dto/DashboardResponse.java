package com.example.demo.dto;

public class DashboardResponse {

    private long totalDepartments;
    private long totalEmployees;
    private long totalCategories;
    private long totalVendors;
    private long totalAssets;
    private long availableAssets;
    private long assignedAssets;
    private long damagedAssets;
    private long underMaintenanceAssets;
    private long totalAssignments;
    private long totalMaintenanceRequests;
    private long totalDamageReports;

    public DashboardResponse() {
    }

    public long getTotalDepartments() {
        return totalDepartments;
    }

    public void setTotalDepartments(long totalDepartments) {
        this.totalDepartments = totalDepartments;
    }

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public long getTotalCategories() {
        return totalCategories;
    }

    public void setTotalCategories(long totalCategories) {
        this.totalCategories = totalCategories;
    }

    public long getTotalVendors() {
        return totalVendors;
    }

    public void setTotalVendors(long totalVendors) {
        this.totalVendors = totalVendors;
    }

    public long getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(long totalAssets) {
        this.totalAssets = totalAssets;
    }

    public long getAvailableAssets() {
        return availableAssets;
    }

    public void setAvailableAssets(long availableAssets) {
        this.availableAssets = availableAssets;
    }

    public long getAssignedAssets() {
        return assignedAssets;
    }

    public void setAssignedAssets(long assignedAssets) {
        this.assignedAssets = assignedAssets;
    }

    public long getDamagedAssets() {
        return damagedAssets;
    }

    public void setDamagedAssets(long damagedAssets) {
        this.damagedAssets = damagedAssets;
    }

    public long getUnderMaintenanceAssets() {
        return underMaintenanceAssets;
    }

    public void setUnderMaintenanceAssets(long underMaintenanceAssets) {
        this.underMaintenanceAssets = underMaintenanceAssets;
    }

    public long getTotalAssignments() {
        return totalAssignments;
    }

    public void setTotalAssignments(long totalAssignments) {
        this.totalAssignments = totalAssignments;
    }

    public long getTotalMaintenanceRequests() {
        return totalMaintenanceRequests;
    }

    public void setTotalMaintenanceRequests(long totalMaintenanceRequests) {
        this.totalMaintenanceRequests = totalMaintenanceRequests;
    }

    public long getTotalDamageReports() {
        return totalDamageReports;
    }

    public void setTotalDamageReports(long totalDamageReports) {
        this.totalDamageReports = totalDamageReports;
    }
}