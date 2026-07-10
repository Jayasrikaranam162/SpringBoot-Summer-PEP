# ☀️ Summer PEP — Day 3

Welcome to **Day 3** of the Summer Professional Experience Program (PEP)!

This day explores integrating Frontend templating with backend MVC architectures, specifically diving into Thymeleaf, as well as basic Login integrations.

---

## 📁 Projects Included

### 1. SpringBoot
A refreshed Spring Boot scaffold with additional configuration and endpoints, serving as a base for building out frontend integrations.

### 2. LoginApp
A structured application for handling Authentication/Login flows.
- Features controllers that handle user sign-in.
- Explores mapping user credentials to background services.

### 3. theymeleaf (Thymeleaf)
Introduction to Thymeleaf, a modern server-side Java template engine.
- Rendering HTML pages directly from Spring Controllers.
- Passing Model data from the backend Java code to the frontend GUI effortlessly using Thymeleaf templating tags (e.g., `th:text`).

### 4. theymeleafDatabase
Taking Thymeleaf further by hooking it up directly to a Database.
- Renders dynamic data lists (like user tables) fetching straight from the JPA Repositories.
- Creating a full-stack, Model-View-Controller functional setup without needing a separate frontend framework (like React or Angular).

---

## 🚀 How to Run

1. Navigate to the desired folder (e.g., `theymeleafDatabase`).
2. Run the application using the Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Open a browser and point to `http://localhost:8080/` to see the generated Thymeleaf templates in action!

---

**Author**: Jayasri Karanam
