package com.kata.bookstore.controller;

import com.kata.bookstore.model.CartItemRequest;
import com.kata.bookstore.model.CartRequest;
import com.kata.bookstore.model.Invoice;
import com.kata.bookstore.service.BookType;
import com.kata.bookstore.service.PricingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final PricingService pricingService;

    public CheckoutController(PricingService pricingService)
    {
        this.pricingService=pricingService;
    }

    @PostMapping
    public Invoice checkout(@Valid @RequestBody CartRequest request)
    {
        Map<BookType,Integer> cart = request.items().stream().collect(Collectors.toMap(CartItemRequest::book,CartItemRequest::quantity));

        double subtotal = cart.values().stream().mapToInt(Integer::intValue).sum()*50;

        double total = pricingService.calculate(cart);
        return new Invoice(subtotal,subtotal-total,total);
    }
}
