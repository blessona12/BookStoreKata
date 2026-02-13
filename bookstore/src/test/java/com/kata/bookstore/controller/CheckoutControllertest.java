package com.kata.bookstore.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CheckoutControllertest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnInvoice() throws Exception
    {

        String request = """
                 {
          "items": [
            { "book": "CLEAN_CODE", "quantity": 1 },
            { "book": "CLEAN_CODER", "quantity": 1 }
          ]
        }""";
        mockMvc.perform(post("/api/checkout")).contentType(MediaType.APPLICATION_JSON)
            .content(request))
                .andExpect(status().isOk())
            .andExpect(jsonPath("$.total").value(95.0));

    }
}
