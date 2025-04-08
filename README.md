# PaySecure API
A secure and scalable RESTful API built using Spring Boot and Spring Security. Implements JWT-based authentication, role-based access control (Admin/User), and salary management functionalities. Designed with clean architecture and modular service-repository layers, making it ideal for HR, payroll, or employee management systems.

## Features
- **User Management**: Register, update, delete, and fetch users.
- **Authentication**: Login with email/password to get a JWT token.
- **Role-Based Access**: Restrict endpoints to `ADMIN` or `USER` roles.
- **Salary Management**: Add and retrieve salary details with automatic 10% tax calculation.
- **API Documentation**: Swagger UI for easy testing.

## Tech Stack
- **Java**: Core language.
- **Spring Boot**: Framework for REST APIs and dependency management.
- **Spring Security**: JWT authentication and role-based authorization.
- **Spring Data JPA**: Database operations with Hibernate.
- **JWT (io.jsonwebtoken)**: Token generation and validation.
- **BCrypt**: Password hashing.
- **Swagger**: API documentation.
- **Database**: Relational DB (e.g., MySQL/PostgreSQL, configurable).
- **Lombok**: Boilerplate reduction.

## Prerequisites
- Java 17+
- Maven
- A relational database (e.g., MySQL or PostgreSQL)
- IDE (e.g., IntelliJ IDEA, Eclipse)

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/[your-username]/paysecure-api.git
   cd paysecure-api
   ```
2. **Clone the Repository**:
   Update src/main/resources/application.properties with your DB details:
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/paysecure_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
   
3. **Build and Run**:
   ```bash
    mvn clean install
    mvn spring-boot:run
   ```
   
4. **Access the API:**
   <br>
   Base URL: http://localhost:8080 <br>
   Swagger UI: http://localhost:8080/swagger-ui/index.html

## 📌 API Endpoints

| Method | Endpoint                     | Description                  | Access Roles     |
|--------|------------------------------|------------------------------|------------------|
| POST   | `/auth/login`                | Login and get JWT token      | Public           |
| POST   | `/api/users/register`        | Register a new user          | Public           |
| GET    | `/api/users/all`             | Get all users                | ADMIN            |
| PUT    | `/api/users/update/{id}`     | Update user details          | ADMIN, USER      |
| DELETE | `/api/users/delete/{id}`     | Delete a user                | ADMIN            |
| POST   | `/salary/add/{userId}`       | Add salary for a user        | ADMIN            |
| GET    | `/salary/get/{userId}`       | Get salary details           | ADMIN, USER      |


**Example Request (Login)**
   ```bash
      curl -X POST http://localhost:8080/auth/login \
      -H "Content-Type: application/json" \
      -d '{"email": "john@example.com", "password": "pass123"}'
   ```

**Response:**
   ```bash
        {
          "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
        }
   ```

**Example Request (Get Salary)**
   ```bash
      curl -X GET http://localhost:8080/salary/get/1 \
      -H "Authorization: Bearer <your-jwt-token>"
   ```
**Response:**
   ```bash
        {
          "userId": 1,
          "username": "john",
          "basicSalary": 5000.0,
          "taxDeduction": 500.0,
          "netSalary": 4500.0
        }
   ```

## Project Structure
```bash
src/main/java/in/Mrityunjay/
├── Configuration          # Security config (JWT, Spring Security)
├── Controller             # REST controllers for users, salary, auth
├── Entity                 # JPA entities (User, Salary)
├── JwtUtil                # JWT generation, validation, and filtering
├── Repo                   # JPA repositories
├── Service                # Business logic interfaces
├── ServiceImpl            # Service implementations
└── MineProjecApplication.java  # Main Spring Boot app
```

<br>

**How to Contribute:**

Fork the repo.  <br>
Create a branch (git checkout -b feature/your-feature). <br>
Commit your changes (git commit -m "Add your feature"). <br>
Push to your branch (git push origin feature/your-feature). <br>
Open a Pull Request. <br>

**Future Improvements:**

Add unit/integration tests with JUnit and Mockito.<br>
Improve error handling with custom exceptions.<br>
Deploy to a cloud platform (e.g., Heroku).<br>
Pair with a simple frontend (e.g., React).<br>

## License
This project is licensed under the MIT License - see the  file for details.

**Contact**

Built by a fresher learning the ropes! Feedback welcome!

GitHub: [mannk26]
LinkedIn: [https://www.linkedin.com/in/man-s-8757a5204/]


## Some Screenshots:
![Screenshot 2025-04-08 145831](https://github.com/user-attachments/assets/87c3e566-35a2-418b-bc31-ecd4643442c5)
![Screenshot 2025-04-08 145915](https://github.com/user-attachments/assets/f2d77e2f-48d5-4759-9ff2-550ef3369070)
![Screenshot 2025-04-08 150446](https://github.com/user-attachments/assets/5b7b3b6f-d339-428b-bd00-341a4e1cb302)
![Screenshot 2025-04-08 150816](https://github.com/user-attachments/assets/be6715de-9d31-43e4-986b-476ad4ad30ef)
![Screenshot 2025-04-08 151031](https://github.com/user-attachments/assets/3baf0101-b476-48c0-87e3-33398acd3148)
![Screenshot 2025-04-08 151056](https://github.com/user-attachments/assets/224bf469-9ad2-4166-8f06-0e27bdef6bbc)
![Screenshot 2025-04-08 151158](https://github.com/user-attachments/assets/b56cbf39-5d9a-4f70-bd9c-218a53c71f98)
![Screenshot 2025-04-08 151627](https://github.com/user-attachments/assets/4e048b4b-8a6c-46c6-b701-27eb2a70fd4b)
![Screenshot 2025-04-08 151635](https://github.com/user-attachments/assets/b40e13f8-8928-4115-b1b0-2f3c73e1efc4)








