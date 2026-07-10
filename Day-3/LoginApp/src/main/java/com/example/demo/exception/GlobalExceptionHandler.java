package com.example.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handles database connection errors
    @ExceptionHandler(org.springframework.dao.DataAccessException.class)
    public String handleDatabaseError(Exception ex, Model model) {
        model.addAttribute("error", "Database error occurred. Please try again later.");
        return "login";
    }

    // Handles all other unexpected exceptions
    @ExceptionHandler(Exception.class)
    public String handleGeneralError(Exception ex, Model model) {
        model.addAttribute("error", "An unexpected error occurred: " + ex.getMessage());
        return "login";
    }
}