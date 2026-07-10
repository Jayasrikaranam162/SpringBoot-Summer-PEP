package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.request.DepartmentRequest;
import com.example.demo.dto.response.DepartmentResponse;
import com.example.demo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public DepartmentResponse createDepartment(
            @Valid @RequestBody DepartmentRequest request) {

        return departmentService.createDepartment(request);
    }

    @GetMapping
    public List<DepartmentResponse> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentResponse getDepartmentById(
            @PathVariable Long id) {

        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentResponse updateDepartment(
            @PathVariable Long id,
            @Valid @RequestBody DepartmentRequest request) {

        return departmentService.updateDepartment(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(
            @PathVariable Long id) {

        departmentService.deleteDepartment(id);

        return "Department deleted successfully with id: " + id;
    }
}