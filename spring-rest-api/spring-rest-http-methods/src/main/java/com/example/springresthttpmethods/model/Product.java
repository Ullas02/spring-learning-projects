package com.example.springresthttpmethods.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Product {

    @NotNull(message = "Product id is required.")
    private Long id;

    @NotBlank(message = "Product name is required.")
    @Size(min = 3, max = 50,
            message = "Product name must be between 3 and 50 characters.")
    private String name;

    @Positive(message = "Price must be greater than zero.")
    private double price;

    public Product() {
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}