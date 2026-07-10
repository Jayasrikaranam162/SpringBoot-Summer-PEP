# 🔐 Employee Backend Login Validation

Welcome to **Project 2: Employee Backend Login Validation**. This repository contains a robust, server-side rendered Spring Boot application focusing on secure login flows, custom exception handling, and Thymeleaf templating.

---

## 🎯 Overview

This project aims to simulate a realistic backend authentication flow (without a database). It processes login credentials from a frontend web form, passes them through a service layer for validation, and utilizes **Global Exception Handling** to gracefully catch improper authentication attempts.

### Key Features
- **MVC Architecture**: Clearly separated `Controller`, `Service`, and `Model` layers.
- **Server-Side Rendering**: HTML interfaces powered by **Thymeleaf** (`login.html` and `welcome.html`).
- **Custom Exceptions**: Specific exceptions created for logical errors (`InvalidUsernameException`, `InvalidPasswordException`).
- **Global Error Handling**: Leveraging `@ControllerAdvice` (`GlobalExceptionHandler.java`) to intercept exceptions and redirect the user back to the login page with helpful error messages.

---

## 🛠️ Technology Stack

- **Framework**: Spring Boot (v4.1)
- **Language**: Java 17
- **Templating Engine**: Thymeleaf
- **Web Layer**: Spring WebMVC

---

## 📂 Project Structure

```
Project2-Day3-EmployeeBackendLoginValidation/
├── src/main/java/com/example/demo/
│   ├── controller/
│   │   └── LoginController.java          # Handles GET/POST requests for login
│   ├── exception/
│   │   ├── GlobalExceptionHandler.java   # Centralized error mapping
│   │   ├── InvalidPasswordException.java
│   │   └── InvalidUsernameException.java
│   ├── model/
│   │   └── Login.java                    # Data Transfer Object for credentials
│   └── service/
│       └── LoginService.java             # Business logic for validation
└── src/main/resources/
    ├── static/css/
    │   └── style.css                     # Custom styling for pages
    └── templates/
        ├── login.html                    # The login interface
        └── welcome.html                  # The success landing page
```

---

## 🚀 How to Run

1. Navigate to the project root directory.
2. Ensure you have Java 17 and Maven installed on your machine.
3. Start the application using Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Open your web browser and navigate to the root domain. The default port is **8080**, so visit:
   👉 **[http://localhost:8080](http://localhost:8080)**
5. Try logging in with valid and invalid credentials to see the custom exceptions in action!

---

## 👥 Authors

Developed as part of the **Summer PEP** (Day 3, Project 2).
