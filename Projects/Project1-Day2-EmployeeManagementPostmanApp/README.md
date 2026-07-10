# Employee Management REST API (Spring Boot + Spring Data JPA)

This is a Spring Boot REST API for Employee Management built during Day 2 of Project 1. It utilizes Spring Data JPA for persistence, an In-Memory H2 Database, and is tested using a Postman client.

## Features

- **RESTful Endpoints**: Full JSON-based APIs for creating, listing, and updating employees.
- **Request Validation**:
  - **Employee Name**: Matches pattern `^[A-Za-z]+( [A-Za-z]+){0,2}$` (Letters only; max 2 spaces allowed).
  - **Employee Age**: Restricts inputs between 18 and 60.
  - **Designation Mapping**: Automatically maps key designations to their default salaries:
    - `Programmer` -> 25,000
    - `Manager` -> 30,000
    - `Tester` -> 20,000
- **Raise Salary REST Endpoint**: Processes salary increases through a request body (`RaiseSalaryRequest`), raising matching employees' salaries by 1% to 10%.
- **H2 Database Console Integration**: Allows runtime inspection of memory data.

---

## Technology Stack

- **Framework**: Spring Boot 3.x (Web & JPA)
- **Database**: H2 Database (In-Memory)
- **Client Testing Tool**: Postman
- **Build Tool**: Maven

---

## Endpoint Details

### 1. Create Employee
* **Endpoint**: `POST /create`
* **Request Header**: `Content-Type: application/json`
* **JSON Body Example**:
  ```json
  {
    "id": 101,
    "name": "John Doe",
    "age": 28,
    "designation": "Programmer"
  }
  ```
* **Notes**: Salary is automatically assigned based on designation. Returns status string: `"Employee Saved Successfully."` or validation error messages.

### 2. Display All Employees
* **Endpoint**: `GET /display`
* **Response**: JSON array of employees.
  ```json
  [
    {
      "id": 101,
      "name": "John Doe",
      "age": 28,
      "designation": "Programmer",
      "salary": 25000.0
    }
  ]
  ```

### 3. Raise Salary
* **Endpoint**: `PUT /raiseSalary`
* **Request Header**: `Content-Type: application/json`
* **JSON Body Example**:
  ```json
  {
    "name": "John Doe",
    "percentage": 5.0
  }
  ```
* **Notes**: Raises the salary of all matching employees by the specified percentage (between 1% and 10%). Returns status string: `"Salary Updated Successfully."` or error message.

---

## How to Run & Test

1. Clone or navigate to the project directory:
   ```bash
   cd Projects/Project1-Day2-EmployeeManagementPostmanApp
   ```
2. Build and run via Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Test using Postman or curl.
   * API Port: `http://localhost:8080/`
   * H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`, Username: `sa`, Password: empty)
