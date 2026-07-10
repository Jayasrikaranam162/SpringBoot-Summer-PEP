package com.example.demo.serviceimpl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.BusinessException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Asset;
import com.example.demo.entity.AssetAssignment;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AssetAssignmentRepository;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AssetAssignmentService;

@Service
public class AssetAssignmentServiceImpl implements AssetAssignmentService {

	private final AssetAssignmentRepository assetAssignmentRepository;
	private final AssetRepository assetRepository;
	private final EmployeeRepository employeeRepository;

	public AssetAssignmentServiceImpl(AssetAssignmentRepository assetAssignmentRepository,
			AssetRepository assetRepository, EmployeeRepository employeeRepository) {
		this.assetAssignmentRepository = assetAssignmentRepository;
		this.assetRepository = assetRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public AssetAssignment assignAsset(Long assetId, Long employeeId, AssetAssignment assignment) {

		Asset asset = assetRepository.findById(assetId)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not found with id: " + assetId));

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

		if (!"AVAILABLE".equalsIgnoreCase(asset.getAssetStatus())) {
			throw new BusinessException(
					"Asset is not available for assignment. Current status: " + asset.getAssetStatus());
		}

		asset.setAssetStatus("ASSIGNED");
		asset.setUpdatedAt(LocalDateTime.now());

		assignment.setAsset(asset);
		assignment.setEmployee(employee);
		assignment.setAssignedDate(LocalDate.now());
		assignment.setAssignmentStatus("ASSIGNED");
		assignment.setCreatedAt(LocalDateTime.now());
		assignment.setUpdatedAt(LocalDateTime.now());

		assetRepository.save(asset);

		return assetAssignmentRepository.save(assignment);
	}

	@Override
	public List<AssetAssignment> getAllAssignments() {
		return assetAssignmentRepository.findAll();
	}

	@Override
	public AssetAssignment getAssignmentById(Long id) {
		return assetAssignmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Assignment not found with id: " + id));
	}

	@Override
	public AssetAssignment returnAsset(Long assignmentId) {

		AssetAssignment assignment = getAssignmentById(assignmentId);

		if ("RETURNED".equalsIgnoreCase(assignment.getAssignmentStatus())) {
			throw new BusinessException("Asset already returned for assignment id: " + assignmentId);
		}

		Asset asset = assignment.getAsset();

		assignment.setAssignmentStatus("RETURNED");
		assignment.setActualReturnDate(LocalDate.now());
		assignment.setUpdatedAt(LocalDateTime.now());

		asset.setAssetStatus("AVAILABLE");
		asset.setUpdatedAt(LocalDateTime.now());

		assetRepository.save(asset);

		return assetAssignmentRepository.save(assignment);
	}

	@Override
	public void deleteAssignment(Long id) {
		AssetAssignment assignment = getAssignmentById(id);
		assetAssignmentRepository.delete(assignment);
	}
}