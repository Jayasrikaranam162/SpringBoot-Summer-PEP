package com.example.demo.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.request.DepartmentRequest;
import com.example.demo.dto.response.DepartmentResponse;
import com.example.demo.entity.Department;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentResponse createDepartment(DepartmentRequest request) {

        Department department = DepartmentMapper.toEntity(request);

        department.setStatus("ACTIVE");
        department.setCreatedAt(LocalDateTime.now());
        department.setUpdatedAt(LocalDateTime.now());

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.toResponse(savedDepartment);
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

        return DepartmentMapper.toResponse(department);
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, DepartmentRequest request) {

        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

        existingDepartment.setDepartmentName(request.getDepartmentName());
        existingDepartment.setDescription(request.getDescription());

        if (request.getStatus() != null) {
            existingDepartment.setStatus(request.getStatus());
        }

        existingDepartment.setUpdatedAt(LocalDateTime.now());

        Department updatedDepartment = departmentRepository.save(existingDepartment);

        return DepartmentMapper.toResponse(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

        departmentRepository.delete(department);
    }
}