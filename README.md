# 🛠️ MicroManage – Scalable Task & Notification Management Platform

**MicroManage** is a full-stack microservices-based system designed to manage employees, tasks, and notifications in a scalable and decoupled architecture. Built using Spring Boot microservices, RabbitMQ for async messaging, ElasticSearch for search, and resilient patterns like circuit breakers and service discovery, the platform offers a real-world view into distributed system design.

> ⚠️ **Note**: The frontend web application is currently under development.

---

## 🧠 System Design Overview

The system is decomposed into the following core domains:
- Employee Management
- Task Management
- Notification Service

Each is implemented as an **independent microservice** with dedicated databases and is orchestrated using **Spring Cloud** and **RabbitMQ** for inter-service messaging.

---

## 📦 Architecture Components

### 🔗 Microservices Layer

| Service       | Description                                                                 |
|---------------|-----------------------------------------------------------------------------|
| **Employee Service** | Manages employee data, uses **MongoDB** for storage                    |
| **Task Service**     | Handles creation, updates, and search for tasks using **MySQL** + **ElasticSearch** |
| **Notification Service** | Sends and tracks notifications, persists data in **PostgreSQL**    |

These services are:
- Independently deployable
- Registered to a central service registry
- Communicate via **REST** and **RabbitMQ**

---

### 🧰 Management Services

| Component        | Role                                                                 |
|------------------|----------------------------------------------------------------------|
| **Eureka Server**     | Acts as a service registry (discovery service)                   |
| **Config Server**     | Centralized config for all microservices via Git repo or file    |
| **Admin Server**      | Real-time monitoring of service health and metrics               |
| **Circuit Breaker**   | Provides fault tolerance (fallback handling if service is down)  |


---

### 💬 Async Messaging with RabbitMQ

- Used for decoupled communication between services (e.g. sending notifications after a task update)
- Improves scalability and reduces tight coupling
- Example: `TaskService` sends a message → `NotificationService` consumes and acts on it

---

### 🔍 Search with ElasticSearch

- Tasks stored in MySQL are indexed into **ElasticSearch** for fast querying
- Enables advanced filtering and full-text search functionality in the future frontend

---

## 🚦 API Gateway

All traffic is routed through a centralized **API Gateway**, which:
- Provides a single entry point to the system
- Performs routing, load balancing, and rate limiting
- Handles token validation and forwards requests to internal services

---

## 🖼 System Flow Example

1. A user creates a new task via the frontend (WIP).
2. `API Gateway` routes the request to `TaskService`.
3. `TaskService` stores the task in **MySQL**, indexes it in **ElasticSearch**, and publishes a message via **RabbitMQ**.
4. `NotificationService` consumes the message, creates a notification, and stores it in **PostgreSQL**.
5. `EmployeeService` can be queried to relate the task to an employee, stored in **MongoDB**.

---

## 📁 Tech Stack

- **Java + Spring Boot** (microservices)
- **MongoDB** – Employee data
- **MySQL + ElasticSearch** – Tasks (storage + search)
- **PostgreSQL** – Notifications
- **RabbitMQ** – Message queue
- **Spring Cloud Config** – Central configuration
- **Eureka** – Service discovery
- **Spring Admin Server** – Monitoring & metrics
- **Circuit Breaker** – Resilience
  
---

## 🚧 Status

| Component        | Status       |
|------------------|--------------|
| Backend Services | ✅ Complete   |
| Messaging System | ✅ Integrated |
| Database Layer   | ✅ Complete   |
| API Gateway      | ✅ Functional |
| Frontend         | 🛠️ In Progress |

---

## 🔐 Future Improvements

- OAuth2 or JWT-based authentication
- Centralized logging via ELK stack
- CI/CD pipelines with GitHub Actions
- Frontend dashboard to manage tasks and employees

---

## 📜 License

MIT – see [`LICENSE`](./LICENSE)

---

## 🙌 Contributions

Contributions, issues, and PRs are welcome. Feel free to fork or reach out!

---

