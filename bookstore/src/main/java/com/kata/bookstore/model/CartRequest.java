package com.kata.bookstore.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CartRequest(

        @NotEmpty
        List<@Valid CartItemRequest> items
) {}