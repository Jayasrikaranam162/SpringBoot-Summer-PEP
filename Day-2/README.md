# ☀️ Summer PEP — Day 2

Welcome to **Day 2** of the Summer Professional Experience Program (PEP)!

On this day, we progressed from a standard Spring Boot MVC architecture to dealing with databases, specifically exploring both H2 in-memory databases and external SQL databases, along with handling custom Exceptions within the Spring ecosystem.

---

## 📁 Projects Included

### 1. SpringDemoH2
A Spring Boot application configured to use an **H2 In-Memory Database**. 
- Learn how to configure H2 in `application.properties`.
- Use Spring Data JPA to automatically generate schemas and query data without needing a separate database instance.

### 2. SpringSql
Connecting a Spring Boot application to a traditional relational database (MySQL/PostgreSQL).
- Demonstrates defining Entities and Repositories.
- Exposes RESTful endpoints directly interacting with the persistent SQL database.

### 3. Exception
A standalone project to experiment with Exception handling in Spring. 
- Features Custom Exception classes.
- Demonstrates `@ControllerAdvice` and `@ExceptionHandler` for globally handling errors and returning proper HTTP status codes.

### 4. ExceptionDatabase
Combines Exception Handing and Database operations.
- Automatically handles and captures Database specific errors (like connection drops, or entity not found) and translates them to user-friendly API responses.

---

## 🚀 How to Run

1. Navigate to the desired project folder (e.g., `SpringSql`).
2. If the project requires a database, ensure the database server is running and `application.properties` specifies the correct credentials.
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Test endpoints using Postman.

---

**Author**: Jayasri Karanam
