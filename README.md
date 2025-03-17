# **Spring Security Demo** 🚀  
This project demonstrates authentication using **Spring Security**, including **Login**, **Signup**, and fetching all users with an **H2 Database**.  

---

## **Technologies Used** 🛠️  
- **Spring Boot**  
- **Spring Security**  
- **H2 Database**  
- **JPA (Hibernate)**  
- **Spring Web**  
- **ModelMapper**  

---

## **Setup Instructions** 📌  

### **1️⃣ Clone the Repository**
```sh
git clone git@github.com:idevhimanshu/SpringSecurityDemo.git
cd SpringSecurityDemo
```

### **2️⃣ Run the Application**
```sh
mvn spring-boot:run
```
The application will start at: `http://localhost:8080`

---

## **H2 Database Console** 🗃️  
- **URL:** `http://localhost:8080/h2-console`  
- **JDBC URL:** `jdbc:h2:mem:testdb`  
- **Username:** `sa`  
- **Password:** *(Leave empty)*  

---

## **API Endpoints** 🔥  

### **1️⃣ Signup - Create New User**
**Endpoint:** `POST /signup`  
**Request Body:**  
```json
{
  "email": "user@example.com",
  "name": "John Doe",
  "password": "securepassword",
  "mobileNumber": "9876543210"
}
```
**Response:**  
```json
{
  "id": 1,
  "email": "user@example.com",
  "name": "John Doe",
  "mobileNumber": "9876543210"
}
```

---

### **2️⃣ Login - Authenticate User**
**Endpoint:** `POST /login`  
**Request Body:**  
```json
{
  "email": "user@example.com",
  "password": "securepassword"
}
```
**Response:**  
```json
{
  "message": "Login Successful",
  "token": "eyJhbGciOiJIUzI1..."
}
```

---

### **3️⃣ Get All Users (Requires Authentication)**
**Endpoint:** `GET /users`  
**Authorization:** `Basic Auth` or `Bearer Token`  
**Response:**  
```json
[
  {
    "id": 1,
    "email": "user@example.com",
    "name": "John Doe",
    "mobileNumber": "9876543210"
  }
]
```

---

## **Security Configuration (Spring Security)**
The following security settings are applied in `AppConfiguration.java`:  
- **CSRF Disabled** ✅  
- **Login & Signup are Public** 🌍  
- **All Other APIs Require Authentication** 🔒  
- **Passwords are Encrypted (BCrypt)** 🔐  

---

## **Contributing** ✨  
If you want to contribute, feel free to fork the repository and submit a pull request.  

---

## **License** 📜  
This project is open-source under the **MIT License**.  
