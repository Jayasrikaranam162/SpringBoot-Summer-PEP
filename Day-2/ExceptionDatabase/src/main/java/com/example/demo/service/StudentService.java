package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // CREATE
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    // READ ONE
    public Student getStudentById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student with ID " + id + " not found."));
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // UPDATE
    public Student updateStudent(int id, Student student) {

        Student existingStudent = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student with ID " + id + " not found."));

        existingStudent.setName(student.getName());
        existingStudent.setCourse(student.getCourse());

        return repository.save(existingStudent);
    }

    // DELETE
    public String deleteStudent(int id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student with ID " + id + " not found."));

        repository.delete(student);

        return "Student deleted successfully.";
    }
}