package com.kata.bookstore.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PricingService {

    private static final Map<Integer,Double> DISCOUNTS=Map.of(2,0.05,3,0.10,4,0.20,5,0.25);

    public double calculate(Map<BookType,Integer> cart)
    {
        if (cart == null || cart.isEmpty()) {
            return 0.0;
        }

        Map<BookType,Integer> copy=new HashMap<>(cart);
        List<Integer> groups = new ArrayList<>();

        while(!copy.isEmpty())
        {
            int unique = copy.keySet().size();
            groups.add(unique);
            copy.replaceAll((k,v)-> v -1);
            copy.entrySet().removeIf(e->e.getValue() <= 0);
        }
        optimize(groups);

        return groups.stream().mapToDouble(this::groupSize).sum();

        return cart.values().stream().mapToInt(Integer::intValue).sum()*50.0;
    }

    private double groupSize(int size)
    {
        double subtotal = size *50.0;
        double discount= DISCOUNTS.getOrDefault(size,0.0);
        return subtotal * (1- discount);
    }

}
