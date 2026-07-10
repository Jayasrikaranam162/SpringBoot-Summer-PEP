# 📦 SummerPEP Day-12 — Order Service (Spring Boot Microservice)

A Spring Boot microservice for managing orders, built as part of the **Summer PEP** program. This project demonstrates building a RESTful order management service with distributed tracing and monitoring capabilities.

---

## 🚀 Tech Stack

| Technology | Purpose |
|---|---|
| **Spring Boot 3.5** | Application framework |
| **Spring Data JPA** | Database persistence |
| **MySQL** | Relational database |
| **Spring Actuator** | Health & metrics endpoints |
| **Micrometer Tracing + Zipkin** | Distributed tracing |
| **Bean Validation** | Input validation |
| **Java 17** | Language version |

---

## 📁 Project Structure

```
order-service/
├── src/main/java/com/example/demo/
│   ├── OrderServiceApplication.java      # Main application entry point
│   ├── controller/
│   │   └── OrderController.java          # REST API endpoints
│   ├── entity/
│   │   └── Order.java                    # JPA entity (orders table)
│   ├── repository/
│   │   └── OrderRepository.java          # Spring Data JPA repository
│   └── service/
│       └── OrderService.java             # Business logic layer
├── src/main/resources/
│   └── application.properties            # App configuration
└── pom.xml                               # Maven dependencies
```

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/orders` | Create a new order |
| `GET` | `/orders` | Retrieve all orders |

### Sample Request — Create Order

```json
POST /orders
Content-Type: application/json

{
  "productName": "Laptop",
  "quantity": 2,
  "price": 75000.00
}
```

---

## 🗃️ Order Entity

| Field | Type | Description |
|---|---|---|
| `id` | Long | Auto-generated primary key |
| `productName` | String | Name of the product |
| `quantity` | Integer | Quantity ordered |
| `price` | Double | Price of the order |

---

## ⚙️ Configuration

The service runs on **port 8081** and connects to a MySQL database (`orders_db`). Key properties:

```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/orders_db
spring.jpa.hibernate.ddl-auto=update
```

**Distributed Tracing** is enabled via Micrometer + Zipkin (endpoint: `http://localhost:9411`).

---

## 🛠️ How to Run

1. **Prerequisites**: Java 17, Maven, MySQL
2. Create a MySQL database named `orders_db`
3. Update `application.properties` with your MySQL credentials
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
5. Access the API at `http://localhost:8081/orders`
6. Actuator endpoints available at `http://localhost:8081/actuator`

---

## 👤 Author

**Jayasri Karanam** — Summer PEP Program, Day 12
