package com.kata.bookstore.model;

public record CartItemRequest(

        @NotNull
        BookType book,

        @Min(1)
        int quantity
) {}