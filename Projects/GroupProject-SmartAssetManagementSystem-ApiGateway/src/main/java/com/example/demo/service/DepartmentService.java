package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.DepartmentRequest;
import com.example.demo.dto.response.DepartmentResponse;

public interface DepartmentService {

    DepartmentResponse createDepartment(DepartmentRequest request);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse getDepartmentById(Long id);

    DepartmentResponse updateDepartment(Long id, DepartmentRequest request);

    void deleteDepartment(Long id);
}