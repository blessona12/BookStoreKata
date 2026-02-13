package com.kata.bookstore.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DiscountPropertiesTest {

    @Autowired
    private DiscountProperties discountProperties;

    @Test
    void shouldLoadDiscountsFromYaml()
    {
        assertEquals(0,25, discountProperties.getDiscounts.get(5));
    }
}
