package com.example.orderservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Represents an order for an automotive part.
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partName;

    private String customerLocation; // e.g., city or address

    private String status; // PENDING, IN_PROGRESS, COMPLETED

    private Long dealerId; // Assigned dealer

    private LocalDateTime createdAt;

    public Order() {
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    public Order(String partName, String customerLocation) {
        this.partName = partName;
        this.customerLocation = customerLocation;
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    // Getters and setters...

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }

    public String getCustomerLocation() { return customerLocation; }
    public void setCustomerLocation(String customerLocation) { this.customerLocation = customerLocation; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getDealerId() { return dealerId; }
    public void setDealerId(Long dealerId) { this.dealerId = dealerId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}