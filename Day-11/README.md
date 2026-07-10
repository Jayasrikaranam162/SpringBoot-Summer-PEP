# ☀️ Summer PEP — Day 11

Welcome to **Day 11** of the Summer Professional Experience Program (PEP)!

Day 11 dives deep into the world of distributed transactions and event-driven microservices!

---

## 📁 Projects Included

### 1. inventory-service, order-service, & payment-service
These three microservices work in tandem to demonstrate an **e-commerce purchase flow**.
- When an order is placed (`order-service`), it must communicate with the `inventory-service` to check stock and the `payment-service` to process transactions.
- Provides the architectural foundation for Saga patterns and event-driven state management between multiple bounded contexts.

---

## 🚀 How to Run

To properly test inter-service behavior, these microservices should be run concurrently.

1. Navigate to each directory individually (`order-service`, etc.).
2. Run each service:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Test the flow by placing an order through the `order-service` gateway/endpoint and verifying the state changes in inventory and payment!

---

**Author**: Jayasri Karanam
