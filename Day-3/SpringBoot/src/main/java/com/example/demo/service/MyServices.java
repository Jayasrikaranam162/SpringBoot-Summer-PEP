package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.MyRepo;

@Service
public class MyServices {

    @Autowired
    private MyRepo repo;

    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public String addEmployee(Employee employee) {
        repo.save(employee);
        return "Employee added successfully!";
    }

    public String updateEmployee(int id, Employee updatedEmployee) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id)); 

        emp.setName(updatedEmployee.getName());
        emp.setAge(updatedEmployee.getAge());
        emp.setSalary(updatedEmployee.getSalary());
        emp.setDesig(updatedEmployee.getDesig());
        repo.save(emp);
        return "Employee updated successfully!";
    }

    public String deleteEmployee(int id) {
        if (!repo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        repo.deleteById(id);
        return "Employee deleted successfully!";
    }

    public String deleteAllEmployees() {
        repo.deleteAll();
        return "All data deleted...!";
    }
}