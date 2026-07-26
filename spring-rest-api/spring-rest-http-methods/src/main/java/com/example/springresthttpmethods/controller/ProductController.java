package com.example.springresthttpmethods.controller;

import com.example.springresthttpmethods.model.Product;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    // simple in-memory storage
    private List<Product> products = new ArrayList<>();

    // add a couple of products when the app starts, just so GET has something to return
    public ProductController() {
        products.add(new Product(1L, "Laptop", 79999.99));
        products.add(new Product(2L, "Mouse", 799.99));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {

        for (Product product : products) {
            if (product.getId().equals(id)) {
                return ResponseEntity.ok(product);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {

        products.add(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }
}