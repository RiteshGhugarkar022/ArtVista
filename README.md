# 🎨 ArtVista – Online Art Gallery & Marketplace

ArtVista is a **web-based online art gallery and marketplace** that connects artists and customers for buying and selling artworks digitally. The platform allows artists to showcase and manage their artworks, while customers can browse verified artworks, place orders, make payments, and track their purchases.
The system also provides an **Admin module** for managing users, verifying artworks, monitoring orders, generating bills, and managing payments.

---

## 📌 Features

### 👤 Authentication & User Management

* Registration and login for **Admin, Artist, and Customer**
* Session-based authentication
* Role-based access to different dashboards
* User profile management

### 🎨 Artist Module

* Artist registration and login
* Manage artist profile
* Upload artwork images
* Add and manage artwork details
* View uploaded artworks
* Manage artwork portfolio
* Receive payment for completed orders

### 🛒 Customer Module

* Customer registration and login
* Browse available and verified artworks
* View artwork details
* Place artwork orders
* Make payments
* View order history
* Track purchases

### 👨‍💼 Admin Module

* Admin login
* Manage users
* Verify uploaded artworks
* Manage artworks
* Monitor customer orders
* Generate bills
* Verify and manage payments
* Manage overall platform activities

### 💳 Payment Module

* Order-based payment processing
* Billing functionality
* Payment status management
* Admin payment verification

### 🖼️ Artwork Management

* Image-based artwork upload
* Artwork verification
* Artwork listing and viewing
* Image storage and retrieval

---

## 🛠️ Technology Stack

| Layer           | Technology            |
| --------------- | --------------------- |
| Frontend        | HTML, CSS, JavaScript |
| Backend         | Java, Spring Boot     |
| Architecture    | MVC                   |
| Database        | PostgreSQL            |
| ORM             | JPA / Hibernate       |
| Build Tool      | Maven                 |
| API Testing     | Postman               |
| Version Control | Git & GitHub          |
| IDE             | Eclipse / VS Code     |

---

## 🏗️ System Architecture

```text
                    ┌─────────────────────┐
                    │      Customer       │
                    └──────────┬──────────┘
                               │
                    ┌──────────▼──────────┐
                    │      Frontend       │
                    │   HTML/CSS/JS       │
                    └──────────┬──────────┘
                               │
                         REST APIs
                               │
                    ┌──────────▼──────────┐
                    │     Spring Boot     │
                    │      Backend        │
                    │        MVC          │
                    └──────────┬──────────┘
                               │
                    ┌──────────▼──────────┐
                    │   JPA / Hibernate   │
                    └──────────┬──────────┘
                               │
                    ┌──────────▼──────────┐
                    │     PostgreSQL      │
                    └─────────────────────┘
```

---


## ⚙️ Prerequisites

Before running the project, make sure the following are installed:

* **JDK 17 or higher**
* **Maven**
* **PostgreSQL**
* **Git**
* **Eclipse or VS Code** 

Check Java version:

```bash
java -version
```

Check Maven version:

```bash
mvn -version
```

---

## 🗄️ Database Configuration

ArtVista uses **PostgreSQL** as its database.

Create a PostgreSQL database:

```sql
CREATE DATABASE artvista;
```
Then configure the database connection in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/artvista
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

Replace `YOUR_PASSWORD` with your PostgreSQL password.

---

## 🚀 Build & Run

### 1. Clone the repository

```bash
git clone https://github.com/RiteshGhugarkar022/ArtVista.git
```

### 2. Navigate to the project

```bash
cd ArtVista
```

### 3. Build the project

```bash
mvn clean package
```

### 4. Run the Spring Boot application

```bash
mvn spring-boot:run
```

### 5. Open the application

Open your browser and visit:
```bash
http://localhost:8080
```

---

## 🔐 User Roles

ArtVista provides three main user roles:

| Role         | Main Responsibilities                                            |
| ------------ | ---------------------------------------------------------------- |
| **Admin**    | Manage users, verify artworks, manage orders and payments        |
| **Artist**   | Upload and manage artworks and view orders                       |
| **Customer** | Browse artworks, place orders, make payments and track purchases |

---

## 🖼️ Artwork Upload

ArtVista supports image-based artwork uploads.

The artwork upload API accepts:

```text
POST /api/arts/upload
```

Content type:

```text
multipart/form-data
```

Uploaded images are stored in:

```text
uploads/
```
---

## 💳 Payment Flow

The basic payment workflow is:

```text
Customer places order
        ↓
Admin verifies order
        ↓
Bill is generated
        ↓
Customer makes payment
        ↓
Admin verifies payment
        ↓
Artist receives payment
```

---

## 🔄 Application Flow

```text
Registration
     ↓
Login
     ↓
Role Verification
     ↓
Dashboard
     ↓
┌──────────────┬───────────────┬───────────────┐
│    Admin     │    Artist     │   Customer    │
├──────────────┼───────────────┼───────────────┤
│ Verify Arts  │ Upload Arts   │ Browse Arts   │
│ Manage Users │ Manage Arts   │ Place Order   │
│ Manage Order │ View Orders   │ Make Payment  │
│ Manage Pay.  │ Receive Pay.  │ Track Order   │
└──────────────┴───────────────┴───────────────┘
```

---

## 🧪 Testing

APIs can be tested using **Postman**.

Example:

```text
POST http://localhost:8080/api/auth/login
```

For artwork upload:

```text
POST http://localhost:8080/api/arts/upload
```

Select:

```text
Body → form-data → File
```

and upload the artwork image.

---

## 🔒 Security

The application provides:

* User authentication
* Role-based authorization
* Protected user functionality
* Database-backed user management
* Controlled artwork verification
* Payment verification workflow

---

## 🎯 Project Objective

The primary objective of ArtVista is to provide a **centralized online platform where artists can showcase and sell their artworks to customers beyond physical galleries**, while providing administrators with tools to manage users, artworks, orders, billing, and payments.

---

## 📄 License

This project is developed for **educational and academic purposes**.
