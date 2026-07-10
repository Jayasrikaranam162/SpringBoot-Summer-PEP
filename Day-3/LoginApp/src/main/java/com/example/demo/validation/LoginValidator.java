package com.example.demo.validation;

import org.springframework.stereotype.Component;

@Component
public class LoginValidator {

    /**
     * Username rules:
     * - Only letters (no numbers, no special chars)
     * - No blank/spaces
     */
    public String validateUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return "Username cannot be blank.";
        }
        if (!username.matches("^[a-zA-Z]+$")) {
            return "Username must contain only letters (no spaces or special characters).";
        }
        return null; // valid
    }

    /**
     * Password rules:
     * - At least 1 special character
     * - At least 1 digit
     * - At least 1 uppercase letter
     * - Min 4, Max 16 characters
     */
    public String validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return "Password cannot be blank.";
        }
        if (password.length() < 4 || password.length() > 16) {
            return "Password must be between 4 and 16 characters.";
        }
        if (!password.matches(".*[A-Z].*")) {
            return "Password must contain at least one uppercase letter.";
        }
        if (!password.matches(".*[0-9].*")) {
            return "Password must contain at least one digit.";
        }
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
            return "Password must contain at least one special character.";
        }
        return null; // valid
    }
}