package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    // CREATE
    public Employee save(Employee employee){
        return repository.save(employee);
    }

    // READ ALL
    public List<Employee> getAll(){
        return repository.findAll();
    }

    // READ BY ID
    public Employee getById(Integer id){
        Optional<Employee> emp = repository.findById(id);
        return emp.orElse(null);
    }

    // UPDATE
    public Employee update(Integer id, Employee employee){

        Employee old = repository.findById(id).orElse(null);

        if(old != null){

            old.setName(employee.getName());
            old.setAge(employee.getAge());
            old.setSalary(employee.getSalary());
            old.setDesig(employee.getDesig());

            return repository.save(old);
        }

        return null;
    }

    // DELETE
    public String delete(Integer id){

        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Employee Deleted Successfully";
        }

        return "Employee Not Found";
    }
}