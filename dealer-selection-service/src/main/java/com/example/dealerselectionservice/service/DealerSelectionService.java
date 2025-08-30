package com.example.dealerselectionservice.service;

import com.example.dealerselectionservice.model.DealerSelectionRequest;
import com.example.dealerselectionservice.model.DealerSelectionResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

/**
 * Service for dealer selection logic.
 * Calls dealer-service for nearby dealers and order-service to update assignment.
 */
@Service
public class DealerSelectionService {

    private final RestTemplate restTemplate;

    public DealerSelectionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Assigns a dealer to the order.
     * If dealerId is provided, assigns that dealer (manual).
     * If not, finds a nearby dealer and assigns automatically.
     */
    public DealerSelectionResponse assignDealer(DealerSelectionRequest req) {
        Long dealerId = req.getDealerId();

        // If manual selection
        if (dealerId != null) {
            boolean updated = updateOrderWithDealer(req.getOrderId(), dealerId);
            return new DealerSelectionResponse(req.getOrderId(), dealerId, updated ? "ASSIGNED" : "FAILED");
        }

        // Automatic selection: fetch nearby dealers from dealer-service
        String dealerServiceUrl = "http://dealer-service:8080/dealers/city/" + req.getCustomerLocation();
        ResponseEntity<List> response = restTemplate.getForEntity(dealerServiceUrl, List.class);

        List<Map<String, Object>> dealers = response.getBody();
        if (dealers == null || dealers.isEmpty()) {
            return new DealerSelectionResponse(req.getOrderId(), null, "FAILED");
        }

        // For demo: pick the first dealer
        Long autoDealerId = Long.valueOf(String.valueOf(dealers.get(0).get("id")));
        boolean updated = updateOrderWithDealer(req.getOrderId(), autoDealerId);

        return new DealerSelectionResponse(req.getOrderId(), autoDealerId, updated ? "ASSIGNED" : "FAILED");
    }

    /**
     * Updates the order (in order-service) with the assigned dealer.
     */
    protected boolean updateOrderWithDealer(Long orderId, Long dealerId) {
        try {
            String url = "http://order-service:8080/orders/" + orderId;
            Map<String, Object> order = restTemplate.getForObject(url, Map.class);
            if (order == null) return false;
            order.put("dealerId", dealerId);

            restTemplate.put(url, order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}