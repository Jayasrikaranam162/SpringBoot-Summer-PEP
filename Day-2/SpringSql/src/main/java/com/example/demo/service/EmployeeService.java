package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    // CREATE
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    // READ ALL
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    // READ BY ID
    public Employee getEmployeeById(int id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    public Employee updateEmployee(int id, Employee employee) {

        Employee emp = repo.findById(id).orElse(null);

        if (emp != null) {
            emp.setName(employee.getName());
            emp.setSalary(employee.getSalary());

            return repo.save(emp);
        }

        return null;
    }

    // DELETE
    public String deleteEmployee(int id) {

        repo.deleteById(id);

        return "Employee Deleted Successfully";
    }

}