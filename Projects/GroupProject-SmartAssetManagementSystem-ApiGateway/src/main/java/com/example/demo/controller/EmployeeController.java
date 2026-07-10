package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/department/{departmentId}")
    public Employee createEmployee(
            @Valid @RequestBody Employee employee,
            @PathVariable Long departmentId) {

        return employeeService.createEmployee(employee, departmentId);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}/department/{departmentId}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee,
            @PathVariable Long departmentId) {

        return employeeService.updateEmployee(id, employee, departmentId);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully with id: " + id;
    }
}