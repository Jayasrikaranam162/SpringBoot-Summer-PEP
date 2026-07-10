# ☀️ Summer PEP — Day 8

Welcome to **Day 8** of the Summer Professional Experience Program (PEP)!

Day 8 focuses on Cross-Cutting concerns and Application Monitoring. We delve into Aspect-Oriented Programming (AOP) for logging, and Spring Actuator for application health metrics.

---

## 📁 Projects Included

### 1. EmployeeAOPLogger
Demonstrates Aspect-Oriented Programming (AOP) using `@Aspect`.
- Cross-cutting concerns are moved out of business logic.
- Automatically intercepts method calls for Logging, ensuring a cleaner controller and service layer.
- Explores `@Before`, `@After`, and `@Around` advice mapping.

### 2. ActuatorDemo
Exposes operational information about the running application using Spring Boot Actuator.
- Provides built-in endpoints for checking `health`, `metrics`, and `env` properties.
- Essential for production monitoring.

---

## 🚀 How to Run

1. Navigate to either `EmployeeAOPLogger` or `ActuatorDemo`.
2. Run the application using Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Test AOP by hitting the standard REST endpoints and observing the console logs!
4. For Actuator, visit `http://localhost:8080/actuator/health`.

---

**Author**: Jayasri Karanam
