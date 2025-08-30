package com.example.dealerselectionservice.model;

/**
 * DTO for dealer selection requests.
 * If dealerId is null, perform automatic assignment.
 */
public class DealerSelectionRequest {
    private Long orderId;
    private String customerLocation;
    private Long dealerId; // Optional, if null = auto-assign

    public DealerSelectionRequest() {}

    public DealerSelectionRequest(Long orderId, String customerLocation, Long dealerId) {
        this.orderId = orderId;
        this.customerLocation = customerLocation;
        this.dealerId = dealerId;
    }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public String getCustomerLocation() { return customerLocation; }
    public void setCustomerLocation(String customerLocation) { this.customerLocation = customerLocation; }

    public Long getDealerId() { return dealerId; }
    public void setDealerId(Long dealerId) { this.dealerId = dealerId; }
}