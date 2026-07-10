package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("title", "Welcome to School Portal");

        model.addAttribute("message",
                "This portal provides students with academic information, announcements, and student services.");

        return "dashboard";
    }

}