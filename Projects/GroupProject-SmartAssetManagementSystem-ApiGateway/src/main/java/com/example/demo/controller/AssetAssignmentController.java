package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AssetAssignment;
import com.example.demo.service.AssetAssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class AssetAssignmentController {

    private final AssetAssignmentService assetAssignmentService;

    public AssetAssignmentController(AssetAssignmentService assetAssignmentService) {
        this.assetAssignmentService = assetAssignmentService;
    }

    @PostMapping("/asset/{assetId}/employee/{employeeId}")
    public AssetAssignment assignAsset(@PathVariable Long assetId,
                                       @PathVariable Long employeeId,
                                       @RequestBody AssetAssignment assignment) {
        return assetAssignmentService.assignAsset(assetId, employeeId, assignment);
    }

    @GetMapping
    public List<AssetAssignment> getAllAssignments() {
        return assetAssignmentService.getAllAssignments();
    }

    @GetMapping("/{id}")
    public AssetAssignment getAssignmentById(@PathVariable Long id) {
        return assetAssignmentService.getAssignmentById(id);
    }

    @PutMapping("/return/{assignmentId}")
    public AssetAssignment returnAsset(@PathVariable Long assignmentId) {
        return assetAssignmentService.returnAsset(assignmentId);
    }

    @DeleteMapping("/{id}")
    public String deleteAssignment(@PathVariable Long id) {
        assetAssignmentService.deleteAssignment(id);
        return "Assignment deleted successfully with id: " + id;
    }
}