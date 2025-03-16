# SpringSecurityDemo

This project is a **Spring Boot** application that implements authentication using **Spring Security** with **H2 Database**. It provides APIs for user registration (signup), login, and fetching all registered users.

# Features

User Registration (Signup)

User Authentication (Login)

Fetch All Users (Secured API)

Password Encryption using BCrypt

Stateless Authentication using Spring Security

H2 In-Memory Database

Tech Stack

Spring Boot

Spring Security

H2 Database

JPA (Hibernate)

BCrypt Password Encoding

1️⃣ Setup Instructions

Clone the Repository

git clone git@github.com:idevhimanshu/SpringSecurityDemo.git
cd SpringSecurityDemo

Build & Run the Application

mvn spring-boot:run

The application will start on http://localhost:8080.

2️⃣ API Endpoints

🔹 User Signup

Endpoint: /signupMethod: POSTRequest Body:

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123",
  "mobileNumber": "1234567890"
}

Response:

{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com"
}

🔹 User Login

Endpoint: /loginMethod: POSTRequest Body:

{
  "email": "john@example.com",
  "password": "password123"
}

Response: (Basic Auth is used for authentication, so no token response)

{
  "message": "Login Successful"
}

🔹 Get All Users (Authenticated API)

Endpoint: /usersMethod: GETAuthentication: Requires Basic Authentication

Response:

[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "mobileNumber": "1234567890"
  }
]

3️⃣ Security Configuration

Security is configured using SecurityFilterChain with the following rules:

/signup and /login are public.

All other endpoints require authentication.

Uses Basic Authentication.

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.csrf(customizer -> customizer.disable())
            .authorizeHttpRequests(request -> request
                    .requestMatchers("/login", "/signup").permitAll()
                    .anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .build();
}

4️⃣ H2 Database Configuration

The application uses an H2 in-memory database. You can access the H2 Console at:

🔗 http://localhost:8080/h2-console

H2 Database Properties (application.properties)

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

5️⃣ Running Tests

Run the tests using Maven:

mvn test

📌 Notes

Ensure Java 17+ and Maven are installed.

To persist data, configure MySQL/PostgreSQL instead of H2.

Replace Basic Authentication with JWT for better security.

🚀 Author

HimanshuGitHub: idevhimanshu

