# ☀️ Summer PEP — Day 5

Welcome to **Day 5** of the Summer Professional Experience Program (PEP)!

Day 5 is all about **Microservices Architecture**. We are taking the leap into the Spring Cloud ecosystem, learning how multiple small services interact with each other in a distributed environment.

---

## 📁 Projects Included

### 1. EurekaServer
The backbone of our microservices! This acts as the **Service Registry**.
- Uses `@EnableEurekaServer`.
- All other services (`ProductService`, `CartService`, etc.) register themselves here.

### 2. ProductService & ProductClient
A microservice dedicated to managing Products.
- Demonstrates how to create a domain-specific service.
- The `ProductClient` shows how to dynamically discover the `ProductService` via Eureka without hardcoding IP addresses.

### 3. CartService
A separate microservice for managing user carts, demonstrating inter-service communication.

### 4. ICICIService & PaymentService1
Services mimicking real-world payment gateways.
- Explores REST template and Feign Client based service-to-service communication.
- Registers seamlessly with the Eureka Discovery Server.

---

## 🚀 How to Run

When running microservices locally, **order matters**!

1. Start **EurekaServer** first (`./mvnw spring-boot:run`).
   - Access the Eureka Dashboard at `http://localhost:8761`.
2. Start the other services (e.g., `ProductService`, `CartService`).
3. Check the Eureka Dashboard to ensure all services have successfully registered!
4. Test inter-service communication via the exposed REST APIs.

---

**Author**: Jayasri Karanam
