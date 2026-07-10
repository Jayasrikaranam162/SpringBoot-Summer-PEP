package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contact(Model model) {

        model.addAttribute("title", "Contact Us");

        model.addAttribute("message",
                "Email : school@gmail.com\nPhone : +91 9999999999\nAddress : Hyderabad, Telangana");

        return "dashboard";
    }

}