package com.kata.bookstore.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DiscountPropertiesTest {

    @Autowired
    private DiscountProperties properties;

    @Test
    void shouldLoadDiscountsFromYaml()
    {
          assertEquals(0.25, properties.getDiscounts().get(5));
    }
}
