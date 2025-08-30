
package com.example.dealerselectionservice.controller;

import com.example.dealerselectionservice.model.DealerSelectionRequest;
import com.example.dealerselectionservice.model.DealerSelectionResponse;
import com.example.dealerselectionservice.service.DealerSelectionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Test for DealerSelectionController.
 */
@WebMvcTest(DealerSelectionController.class)
public class DealerSelectionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DealerSelectionService dealerSelectionService;

    @Test
    void testAssignDealer() throws Exception {
        Mockito.when(dealerSelectionService.assignDealer(any(DealerSelectionRequest.class)))
                .thenReturn(new DealerSelectionResponse(1L, 2L, "ASSIGNED"));

        mockMvc.perform(post("/dealer-selection/assign")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"orderId\":1,\"customerLocation\":\"Boston\",\"dealerId\":2}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("ASSIGNED"));
    }
}