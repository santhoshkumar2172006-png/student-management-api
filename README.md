# Student Management REST API

A backend REST API for managing student records using Spring Boot, Spring Data JPA, and PostgreSQL.

The application provides APIs for creating, viewing, updating, deleting, searching, and filtering student records. It also includes input validation, duplicate register-number handling, global exception handling, and a Department–Student relationship.

---

## 🚀 Features

- Create a new student
- Get all students
- Get a student by ID
- Update student details
- Delete a student
- Search students by name
- Filter students by department
- Filter students by year
- Filter students by semester
- Validate student input
- Prevent duplicate register numbers
- Global exception handling
- Department management
- Student–Department relationship
- PostgreSQL database integration
- RESTful API architecture

---

## 🛠️ Technologies Used

### Backend

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Maven

### Database

- PostgreSQL
- pgAdmin 4

### API Testing

- Postman

### Development Tools

- Visual Studio Code
- Git
- GitHub

---

## 📁 Project Structure

```text
student-management/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── studentmanagement/
│   │   │           └── student_management/
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   ├── StudentController.java
│   │   │               │   └── DepartmentController.java
│   │   │               │
│   │   │               ├── entity/
│   │   │               │   ├── Student.java
│   │   │               │   └── Department.java
│   │   │               │
│   │   │               ├── repository/
│   │   │               │   ├── StudentRepository.java
│   │   │               │   └── DepartmentRepository.java
│   │   │               │
│   │   │               ├── service/
│   │   │               │   ├── StudentService.java
│   │   │               │   └── DepartmentService.java
│   │   │               │
│   │   │               ├── exception/
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   └── StudentAlreadyExistsException.java
│   │   │               │
│   │   │               └── StudentManagementApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
