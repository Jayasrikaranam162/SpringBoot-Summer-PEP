# ☀️ Summer PEP — Day 9

Welcome to **Day 9** of the Summer Professional Experience Program (PEP)!

This entire module is dedicated to securing our applications using **Spring Security**. We start from basic authentication and scale all the way up to advanced JWT implementations.

---

## 📁 Projects Included

### 1. Spring-Security-Demo & Spring-Security
Explores the default behaviors of Spring Security.
- Setting up in-memory authentication.
- Securing specific REST endpoints while leaving others public.

### 2. Spring-Security-DB
Connects Spring Security to a real database!
- Uses `UserDetailsService` to fetch user credentials and roles from a persistent database for authentication.

### 3. jwt-demo
Advanced Stateless Authentication.
- Instead of using Sessions, it implements **JSON Web Tokens (JWT)**.
- Explores extracting, validating, and generating tokens for stateless, scalable microservice security.

---

## 🚀 How to Run

1. Navigate to the desired project folder.
2. If running the DB project, ensure `application.properties` points to an active SQL database.
3. Run the application using the Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Test using Postman! For JWT, ensure you pass the generated token in the `Authorization: Bearer <token>` header for subsequent requests.

---

**Author**: Jayasri Karanam
