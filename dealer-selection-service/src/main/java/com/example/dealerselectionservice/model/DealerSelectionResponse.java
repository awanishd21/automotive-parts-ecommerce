package com.example.dealerselectionservice.model;

/**
 * DTO for dealer selection responses.
 */
public class DealerSelectionResponse {
    private Long orderId;
    private Long assignedDealerId;
    private String status; // e.g. "ASSIGNED", "FAILED"

    public DealerSelectionResponse() {}

    public DealerSelectionResponse(Long orderId, Long assignedDealerId, String status) {
        this.orderId = orderId;
        this.assignedDealerId = assignedDealerId;
        this.status = status;
    }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Long getAssignedDealerId() { return assignedDealerId; }
    public void setAssignedDealerId(Long assignedDealerId) { this.assignedDealerId = assignedDealerId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}