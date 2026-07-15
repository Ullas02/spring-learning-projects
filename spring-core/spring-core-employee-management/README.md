# Spring Core Employee Management System

A simple **Spring Core** project demonstrating the fundamental concepts of the Spring Framework using a layered architecture.

This project was built as the **Module 1 Capstone Project** of the Spring learning journey.

---

# 🎯 Project Objective

The objective of this project is to understand how Spring manages objects (Beans), performs Dependency Injection, and organizes applications using clean architecture.

This project intentionally does **not** use:

* Spring Boot
* Database
* REST APIs
* Spring MVC

The focus is entirely on **Spring Core** concepts.

---

# 🏗️ Project Architecture

```
                App
                 │
                 ▼
        EmployeeService
          │         │
          ▼         ▼
EmployeeRepository  NotificationService
```

---

# 📂 Project Structure

```
spring-core-employee-management
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.employee
│   │   │
│   │   │── App.java
│   │   │── AppConfig.java
│   │   │
│   │   ├── model
│   │   │     └── Employee.java
│   │   │
│   │   ├── repository
│   │   │     └── EmployeeRepository.java
│   │   │
│   │   └── service
│   │         ├── EmployeeService.java
│   │         ├── NotificationService.java
│   │         ├── ConsoleNotificationService.java
│   │         └── EmailNotificationService.java
│   │
│   └── resources
│         └── application.properties
│
└── pom.xml
```

---

# 📚 Spring Concepts Covered

* Spring IoC Container
* Dependency Injection (Constructor Injection)
* Component Scanning
* Java-based Configuration
* Spring Beans
* `@Service`
* `@Repository`
* `@Configuration`
* `@ComponentScan`
* `@Value`
* `@Profile`
* `@PostConstruct`
* `@PreDestroy`

---

# 🚀 How to Run

### 1. Clone the repository

```bash
git clone <repository-url>
```

### 2. Open the project

Open the project in **IntelliJ IDEA**.

### 3. Build the project

Allow Maven to download all dependencies.

### 4. Run

Execute:

```
App.java
```

---

# 🔄 Switching Profiles

The project contains two implementations of `NotificationService`.

### Development Profile

```java
context.getEnvironment().setActiveProfiles("dev");
```

Output:

```
DEV NOTIFICATION
```

---

### Production Profile

```java
context.getEnvironment().setActiveProfiles("prod");
```

Output:

```
EMAIL NOTIFICATION
```

---

# ⚙️ Configuration

`application.properties`

```properties
application.name=Spring Core Employee Management System
```

This property is injected using:

```java
@Value("${application.name}")
```

---

# 🏛️ Design Principles Used

* Layered Architecture
* Separation of Concerns
* Constructor Injection
* Interface-based Programming
* Stateless Service Design
* Clean Package Structure

---

# 💡 Key Learnings

Through this project, I learned how to:

* Configure a Spring application using Java Configuration.
* Create and manage Spring Beans.
* Perform Dependency Injection using constructors.
* Use `@Value` to inject configuration values.
* Load environment-specific Beans using Spring Profiles.
* Execute initialization and cleanup logic with lifecycle annotations.
* Organize a Spring application using a layered architecture.

---

# 🔮 Future Enhancements

This project can be extended by adding:

* Spring Boot
* Spring MVC
* REST APIs
* Spring Data JPA
* MySQL/PostgreSQL
* Validation
* Exception Handling
* Logging
* Spring Security
* Docker

---

# 👨‍💻 Author

Ullas