# ☀️ Summer PEP — Day 6

Welcome to **Day 6** of the Summer Professional Experience Program (PEP)!

On Day 6, we expanded our Microservices ecosystem by introducing an **API Gateway** and building out specific domain dashboards and services.

---

## 📁 Projects Included

### 1. ApiGateway
A centralized **Spring Cloud Gateway** that routes client requests to appropriate downstream microservices.
- Replaces direct calls to individual microservices.
- Uses `application.properties` or `application.yml` to define routes, filters, and predicates.

### 2. Hello
A simple test service to ensure our API Gateway routes are functioning correctly before adding complex business logic.

### 3. cart-service
An enhanced version of the Cart Microservice integrated fully into the API Gateway ecosystem.

### 4. SchoolDashboard & single-page-navigation-demo
Exploring frontend paradigms and dashboard creation!
- Dashboard configurations targeting REST APIs.
- Demonstrating how Single Page Applications (SPAs) navigate and fetch data from backend gateways rather than polling individual microservices directly.

---

## 🚀 How to Run

1. (Optional but recommended) Run your Eureka Server from Day 5.
2. Start the downstream microservices (`cart-service`, `Hello`, `SchoolDashboard`).
3. Start the **ApiGateway**.
4. Send all your requests to the API Gateway port (typically `8080` or `9090`), and watch it route traffic exactly where it needs to go!

---

**Author**: Jayasri Karanam
