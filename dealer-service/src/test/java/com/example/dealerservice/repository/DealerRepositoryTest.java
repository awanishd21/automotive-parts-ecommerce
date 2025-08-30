package com.example.dealerservice.repository;

import com.example.dealerservice.model.Dealer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DealerRepositoryTest {

    @Autowired
    private DealerRepository dealerRepository;

    @Test
    public void testFindByCity() {
        Dealer d = new Dealer("AutoZone", "Boston", "123 Main St", "555-1234");
        dealerRepository.save(d);
        List<Dealer> bostonDealers = dealerRepository.findByCity("Boston");
        assertFalse(bostonDealers.isEmpty());
        assertEquals("AutoZone", bostonDealers.get(0).getName());
    }
}