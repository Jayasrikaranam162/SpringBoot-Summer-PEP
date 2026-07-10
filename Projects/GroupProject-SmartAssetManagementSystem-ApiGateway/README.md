# 🏢 Smart Asset Management System

Welcome to the **Smart Asset Management System (SAMS)**! This project is a comprehensive backend application designed to streamline and automate organizational asset tracking, employee assignments, damage logging, and maintenance requests.

---

## 🎯 Overview

The system is built as a robust monolithic **Spring Boot 4.1** application, serving as the core engine for asset management. It handles everything from tracking individual IT assets to assigning them across different departments and monitoring their lifecycle via maintenance and damage reports.

### Key Features
- **Asset Lifecycle Management**: Track complete inventory, from procurement to retirement.
- **Employee & Department Mapping**: Assign hardware directly to employees within specific departments.
- **Maintenance & Damage Tracking**: Create structured tickets for broken assets or scheduled upkeep.
- **Role-Based Security**: Secured endpoints ensuring that only authorized users get access.
- **Interactive API Documentation**: Explore the live API easily using Swagger UI!

---

## 🛠️ Technology Stack

- **Framework**: Spring Boot (v4.1)
- **Language**: Java 17
- **Database**: PostgreSQL
- **Persistence**: Spring Data JPA / Hibernate
- **Security**: Spring Security
- **API Documentation**: Springdoc OpenAPI (Swagger)
- **Templating**: Thymeleaf
- **Boilerplate Reduction**: Lombok

---

## 📂 Core Modules (Entities)

The system is designed around a highly relational data model to cover complex business requirements:
- **`AppUser` & `Role`**: Security layer handling authentication.
- **`Asset` & `AssetCategory`**: Inventory management and classification.
- **`Employee` & `Department`**: Organizational structure mapping.
- **`AssetAssignment`**: Link tracking who currently holds which asset.
- **`MaintenanceRequest` & `DamageReport`**: Service ticketing system.
- **`Vendor`**: Supplier management.

---

## ⚙️ Getting Started

### Prerequisites
- **Java 17** installed and configured.
- **Maven** (or use the provided wrapper).
- **PostgreSQL** running locally on default port `5432`.

### Database Setup
1. Open pgAdmin or any PostgreSQL CLI.
2. Create a database named exactly: `Asset_database`.
3. *(Optional)* If your local database uses a different username/password, adjust `src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=postgres
   spring.datasource.password=Jaya123
   ```
4. Spring Data JPA is configured with `ddl-auto=update` — all tables will generate automatically on your first boot!

### Running the Application

Navigate to the project root and start the application using the Maven wrapper:
```bash
# For Windows
./mvnw.cmd spring-boot:run

# For macOS/Linux
./mvnw spring-boot:run
```
The server will start up on **port 9999**.

---

## 📡 Evaluating the API

SAMS comes pre-configured with Swagger UI for effortless exploratory testing of the REST endpoints. 
Once the server is running, navigate to:

👉 **[http://localhost:9999/swagger-ui.html](http://localhost:9999/swagger-ui.html)**

---

## 👥 Authors

Developed as a part of the **Summer PEP Group Project**.
