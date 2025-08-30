package com.example.dealerselectionservice.controller;

import com.example.dealerselectionservice.model.DealerSelectionRequest;
import com.example.dealerselectionservice.model.DealerSelectionResponse;
import com.example.dealerselectionservice.service.DealerSelectionService;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for dealer selection.
 */
@RestController
@RequestMapping("/dealer-selection")
public class DealerSelectionController {

    private final DealerSelectionService dealerSelectionService;

    public DealerSelectionController(DealerSelectionService dealerSelectionService) {
        this.dealerSelectionService = dealerSelectionService;
    }

    /**
     * Assign dealer (manual or automatic).
     */
    @PostMapping("/assign")
    public DealerSelectionResponse assignDealer(@RequestBody DealerSelectionRequest req) {
        return dealerSelectionService.assignDealer(req);
    }
}