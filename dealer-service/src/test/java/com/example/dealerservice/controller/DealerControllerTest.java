package com.example.dealerservice.controller;

import com.example.dealerservice.model.Dealer;
import com.example.dealerservice.repository.DealerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for DealerController.
 */
@WebMvcTest(DealerController.class)
public class DealerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DealerRepository dealerRepository;

    @BeforeEach
    void setup() {
        Mockito.when(dealerRepository.save(any(Dealer.class)))
                .thenReturn(new Dealer("Test Dealer", "Boston", "123 Main St", "555-1234"));
    }

    @Test
    void testCreateDealer() throws Exception {
        mockMvc.perform(post("/dealers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Test Dealer\",\"city\":\"Boston\",\"address\":\"123 Main St\",\"contact\":\"555-1234\"}"))
                .andExpect(status().isOk());
    }
}