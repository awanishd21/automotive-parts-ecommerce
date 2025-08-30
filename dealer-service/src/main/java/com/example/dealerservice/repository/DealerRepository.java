package com.example.dealerservice.repository;

import com.example.dealerservice.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for Dealer entity.
 */
public interface DealerRepository extends JpaRepository<Dealer, Long> {
    List<Dealer> findByCity(String city);
}
