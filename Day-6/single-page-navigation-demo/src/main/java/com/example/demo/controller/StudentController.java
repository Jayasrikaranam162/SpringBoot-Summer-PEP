package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String student(Model model) {

        model.addAttribute("title", "Student Details");
        model.addAttribute("name", "Jaya");
        model.addAttribute("course", "B.Tech CSE");
        model.addAttribute("semester", "7th Semester");
        model.addAttribute("college", "Lovely Professional University");

        return "dashboard";
    }
}