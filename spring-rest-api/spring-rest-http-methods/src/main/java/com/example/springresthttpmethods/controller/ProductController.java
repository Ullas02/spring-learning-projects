package com.example.springresthttpmethods.controller;

import com.example.springresthttpmethods.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(
            @PathVariable Long id) {

        Product product = new Product(
                id,
                "Laptop",
                79999.99
        );

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct() {

        Product product = new Product(
                100L,
                "Monitor",
                15999.99
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id) {

        return ResponseEntity.noContent().build();
    }
}
