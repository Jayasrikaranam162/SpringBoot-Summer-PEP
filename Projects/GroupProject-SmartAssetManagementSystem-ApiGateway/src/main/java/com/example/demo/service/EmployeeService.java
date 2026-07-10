package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee employee, Long departmentId);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee, Long departmentId);

    void deleteEmployee(Long id);
}