package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(Model model) {

        model.addAttribute("title", "About Our School");

        model.addAttribute("message",
                "Our school was established in 1990 with a mission to provide quality education and holistic development to every student.");

        return "dashboard";
    }

}