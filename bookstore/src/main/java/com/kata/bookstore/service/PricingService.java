package com.kata.bookstore.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PricingService {

    public double calculate(Map<BookType,Integer> cart)
    {
        if (cart == null || cart.isEmpty()) {
            return 0.0;
        }
        return 0.0;
    }

}
