package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AssetAssignment;

public interface AssetAssignmentService {

    AssetAssignment assignAsset(Long assetId, Long employeeId, AssetAssignment assignment);

    List<AssetAssignment> getAllAssignments();

    AssetAssignment getAssignmentById(Long id);

    AssetAssignment returnAsset(Long assignmentId);

    void deleteAssignment(Long id);
}