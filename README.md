# Automotive Parts Ecommerce Microservices System

## Overview

This project is a demo automotive parts ecommerce system built using Spring Boot microservices and Angular microfrontends, designed for scalable deployment with Docker.  
Features include part search, dealer selection (manual/automatic), dealer dashboard, and TDD-backed test coverage.

---

## Architecture

- **Backend Microservices (Java/Spring Boot):**
  - `order-service`: Orders CRUD, status, dealer assignment.
  - `dealer-service`: Dealer CRUD, search by city (for nearby listing).
  - `dealer-selection-service`: Assigns orders to dealers, auto/manual.

- **Frontend Microfrontends (Angular):**
  - `customer-portal`: Search parts, list dealers, place orders.
  - `dealer-dashboard`: Dealer login, view/manage/fulfill orders.

Each service/frontend is independently dockerized and deployable.

---

## Running the Project

### **Prerequisites**

- Docker & Docker Compose
- Java 17+ (for building JARs)
- Node.js 20+ & Angular CLI (for building Angular apps)

### **Build**

1. **Backend:**  
   In each backend directory, build the JAR:
   ```bash
   mvn clean package
   ```
2. **Frontend:**  
   In each frontend directory:
   ```bash
   npm install
   npm run build
   ```

### **Run with Docker Compose**

```bash
docker-compose up --build
```

### **Services and Ports**

- order-service: `localhost:8081`
- dealer-service: `localhost:8082`
- dealer-selection-service: `localhost:8083`
- customer-portal: `localhost:4200`
- dealer-dashboard: `localhost:4300`

---

## Testing

- **Backend:**  
  In each Spring service:
  ```bash
  mvn test
  ```
- **Frontend:**  
  In each Angular frontend:
  ```bash
  npm test
  ```

---

## Flow

- Customer searches for a part and their city.
- Nearby dealers are listed (from `dealer-service`).
- Customer can select a dealer or opt for auto-assignment.
- Order is created (`order-service`), dealer assigned (`dealer-selection-service`).
- Dealer can use the dashboard to see orders and fulfill manually.

---

## Documentation

- Each backend method is documented with Javadoc.
- Angular components and services are documented with JSDoc.
- See each service for more details and code comments.

---

## Extending

- Add authentication/authorization (Spring Security, JWT, or OAuth).
- Add payment, inventory, and notifications microservices.
- Integrate with a microfrontend shell for dynamic composition.

---

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