package com.example.dealerselectionservice.service;

import com.example.dealerselectionservice.model.DealerSelectionRequest;
import com.example.dealerselectionservice.model.DealerSelectionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DealerSelectionServiceTest {

    private DealerSelectionService selectionService;
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        restTemplate = mock(RestTemplate.class);
        selectionService = new DealerSelectionService(restTemplate);
    }

    @Test
    public void testAssignDealerManual() {
        DealerSelectionRequest req = new DealerSelectionRequest(1L, "Boston", 2L);
        DealerSelectionService spy = spy(selectionService);
        doReturn(true).when(spy).updateOrderWithDealer(1L, 2L);
        DealerSelectionResponse resp = spy.assignDealer(req);
        assertEquals("ASSIGNED", resp.getStatus());
        assertEquals(2L, resp.getAssignedDealerId());
    }
}