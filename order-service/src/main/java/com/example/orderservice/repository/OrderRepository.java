package com.example.orderservice.repository;

import com.example.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for Order entity.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByDealerId(Long dealerId);
    List<Order> findByStatus(String status);
}