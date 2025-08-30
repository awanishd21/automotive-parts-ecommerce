package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing orders.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Create a new order.
     */
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    /**
     * Get all orders.
     */
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Get order by id.
     */
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable Long id) {
        return orderRepository.findById(id);
    }

    /**
     * Update the status of an order.
     */
    @PatchMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id, @RequestBody String status) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(status.replace("\"", "")); // Remove quotes if sent as JSON string
        return orderRepository.save(order);
    }

    /**
     * Assign dealer to an order.
     */
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setDealerId(updatedOrder.getDealerId());
        return orderRepository.save(order);
    }

    /**
     * Find orders by dealer.
     */
    @GetMapping("/dealer/{dealerId}")
    public List<Order> getOrdersByDealer(@PathVariable Long dealerId) {
        return orderRepository.findByDealerId(dealerId);
    }
}