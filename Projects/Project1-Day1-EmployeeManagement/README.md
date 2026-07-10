# Employee Management Web Application (Spring Boot MVC + Thymeleaf)

This is a Web-based Employee Management application built during Day 1 of Project 1. It utilizes Spring Boot MVC patterns with Thymeleaf templates for the user interface, Spring Data JPA for persistence, and an In-Memory H2 Database.

## Features

- **Interactive HTML UI Pages**: Simple templates for home, employee creation form, list directory, salary hikes, and exiting.
- **Form Validations**:
  - **Employee Name**: Checked against regex pattern `^[A-Za-z]+( [A-Za-z]+){0,2}$` (Letters only; max 2 spaces allowed).
  - **Employee Age**: Restricts inputs between 18 and 60.
  - **Designation Mapping**: Automatically maps key designations to their default salaries:
    - `Programmer` -> 25,000
    - `Manager` -> 30,000
    - `Tester` -> 20,000
- **Raise Salary Utility**: Form allows users to execute salary increases by a given percentage (1% to 10%) filtered by employee name.
- **H2 Database Console Integration**: Allows runtime inspection of memory data.

---

## Technology Stack

- **Framework**: Spring Boot 3.x
- **View Engine**: Thymeleaf Template Engine
- **ORM / Persistence**: Spring Data JPA
- **Database**: H2 Database (In-Memory)
- **Build Tool**: Maven

---

## Endpoint Details

- `GET /` - Home landing page (`index.html`).
- `GET /create-form` - Renders the form to add a new employee (`create.html`).
- `POST /create` - Handles employee creation form submits with validation checks.
- `GET /display` - Lists all employees currently stored in database (`display.html`).
- `GET /raise-form` - Form to raise employee salary (`raiseSalary.html`).
- `POST /raiseSalary` - Processes salary increment logic for search results matching target name.
- `GET /exit` - Renders the exit screen overlay (`exit.html`).

---

## How to Run

1. Clone or navigate to the project directory:
   ```bash
   cd Projects/Project1-Day1-EmployeeManagement
   ```
2. Build and run via Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Open your browser and navigate to:
   * Application UI: [http://localhost:8080/](http://localhost:8080/)
   * H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console) (JDBC URL: `jdbc:h2:mem:testdb`, Username: `sa`, Password: empty)
