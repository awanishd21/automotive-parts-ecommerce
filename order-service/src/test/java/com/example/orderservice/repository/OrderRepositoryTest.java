package com.example.orderservice.repository;

import com.example.orderservice.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testFindByDealerId() {
        Order o = new Order("Brake Pad", "Boston");
        o.setDealerId(1L);
        orderRepository.save(o);
        List<Order> byDealer = orderRepository.findByDealerId(1L);
        assertFalse(byDealer.isEmpty());
        assertEquals("Brake Pad", byDealer.get(0).getPartName());
    }

    @Test
    public void testFindByStatus() {
        Order o = new Order("Brake Pad", "Boston");
        o.setStatus("COMPLETED");
        orderRepository.save(o);
        List<Order> completed = orderRepository.findByStatus("COMPLETED");
        assertFalse(completed.isEmpty());
    }
}