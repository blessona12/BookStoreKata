package com.kata.bookstore.model;

public record CartRequest(

        @NotEmpty
        List<@Valid CartItemRequest> items
) {}