# HR Management System – JavaFX Project
> Developed by: Sakshi 
> Course: JavaFX Lab Project  
> IDE: Visual Studio Code  
> Database: MySQL  

---

## 📌 Project Overview

The **HR Management System** is a simple JavaFX-based desktop application that simulates a basic Human Resources management workflow. It includes user login, employee and admin management, salary records, and dashboard navigation. It uses **MySQL** for persistent data storage and follows the **MVC pattern** for clean code separation.

---

## ✅ Features Implemented

### 🔐 Login Module
- Email + Password based login
- Validates against the `admin` table in MySQL

### 📊 Dashboard
- Buttons for navigating to:
  - Admin page
  - Employee page
  - Logout
  - Exit
- Displays current date and logged-in user's email

### 👩‍💼 Admin Page
- Table view showing admins
- Buttons to Create, Update, Delete, View, and Back

### 👨‍💼 Employee Page
- Table view showing employees
- Buttons to Create, Update, Delete, View, and Back

### 💾 MySQL Integration
- Tables: `admin`, `employee_detail`, `salary`
- DAO classes for performing CRUD operations using JDBC

---

## 🧰 Technologies Used

| Technology        | Purpose                              |
|-------------------|--------------------------------------|
| Java 17+          | Core programming language            |
| JavaFX 21         | GUI framework                        |
| MySQL             | Database backend                     |
| JDBC              | Database connection in Java          |
| VS Code           | Development environment              |
| Git + GitHub      | Version control and documentation    |

---

## 🛠️ Project Setup Instructions

### 📦 Prerequisites
- Java SDK 17+
- JavaFX SDK (e.g., javafx-sdk-21)
- MySQL Server
- MySQL Connector JAR
- VS Code + Java Extension Pack

### 🧱 Database Setup
Create a MySQL database named `hr_management` and run the following SQL scripts:

```sql
CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE employee_detail (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    department VARCHAR(100),
    role VARCHAR(100),
    hire_date DATE
);

CREATE TABLE salary (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    monthly_salary DECIMAL(10,2),
    bonus DECIMAL(10,2),
    FOREIGN KEY (employee_id) REFERENCES employee_detail(id)
);
