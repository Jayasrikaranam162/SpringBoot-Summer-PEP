package com.example.demo.mapper;

import com.example.demo.dto.request.DepartmentRequest;
import com.example.demo.dto.response.DepartmentResponse;
import com.example.demo.entity.Department;

public class DepartmentMapper {

    public static Department toEntity(DepartmentRequest request) {

        Department department = new Department();

        department.setDepartmentName(request.getDepartmentName());
        department.setDescription(request.getDescription());
        department.setStatus(request.getStatus());

        return department;
    }

    public static DepartmentResponse toResponse(Department department) {

        DepartmentResponse response = new DepartmentResponse();

        response.setDepartmentId(department.getDepartmentId());
        response.setDepartmentName(department.getDepartmentName());
        response.setDescription(department.getDescription());
        response.setStatus(department.getStatus());
        response.setCreatedAt(department.getCreatedAt());
        response.setUpdatedAt(department.getUpdatedAt());

        return response;
    }
}