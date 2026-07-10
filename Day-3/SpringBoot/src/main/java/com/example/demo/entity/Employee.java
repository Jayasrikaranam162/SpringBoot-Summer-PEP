package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @Min(value = 1, message = "Salary must be positive")
    private int salary;

    @NotBlank(message = "Designation cannot be blank")
    private String desig;

    public Employee() {}

    public Employee(int id, String name, int age, int salary, String desig) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.desig = desig;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }
    public String getDesig() { return desig; }
    public void setDesig(String desig) { this.desig = desig; }
}