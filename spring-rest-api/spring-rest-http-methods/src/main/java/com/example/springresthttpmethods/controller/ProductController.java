package com.example.springresthttpmethods.controller;

import com.example.springresthttpmethods.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/product")
    public Product getProduct() {
        return new Product(
                1L,
                "Laptop",
                79999.99
        );
    }

    @GetMapping("/products")
    public List<Product> getProducts() {

        return List.of(
                new Product(1L, "Laptop", 79999.99),
                new Product(2L, "Mouse", 999.99),
                new Product(3L, "Keyboard", 2499.00)
        );

    }

}
