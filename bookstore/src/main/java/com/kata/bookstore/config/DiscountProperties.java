package com.kata.bookstore.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix ="pricing")
public class DiscountProperties {

    private Map<Integer, Double> discounts = new HashMap<>();

    public Map<Integer, Double> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Map<Integer, Double> discounts) {
        this.discounts = discounts;
    }
}
