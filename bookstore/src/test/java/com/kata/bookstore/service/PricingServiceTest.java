package com.kata.bookstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PricingServiceTest {

    @Autowired
    private PricingService pricingService;

    @Test
    void shouldReturnZeroWhenCartIsNull()
    {
        double total= pricingService.calculate(null);
        assertEquals(0.0,total);
    }

    @Test
    void shouldReturnZeroWhenCartIsEmpty()
    {
        double total= pricingService.calculate(Map.of());
        assertEquals(0.0,total);
    }

    @Test
    void shouldReturnFiftyForSingleBook()
    {
        Map<BookType, Integer> cart = Map.of(BookType.CLEAN_CODE,1);

        double total = pricingService.calculate(cart);
        assertEquals(50.0,total);
    }

}
