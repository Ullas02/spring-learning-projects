package com.example.springresthttpmethods.controller;

import com.example.springresthttpmethods.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "Endpoints for managing products")
public class ProductController {

    // simple in-memory storage
    private List<Product> products = new ArrayList<>();

    // add a couple of products when the app starts, just so GET has something to return
    public ProductController() {
        products.add(new Product(1L, "Laptop", 79999.99));
        products.add(new Product(2L, "Mouse", 799.99));
    }

    @Operation(
            summary = "Get a product by id",
            description = "Returns a single product if it exists in the in-memory list."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(
            @Parameter(description = "Id of the product to retrieve", example = "1")
            @PathVariable Long id) {

        for (Product product : products) {
            if (product.getId().equals(id)) {
                return ResponseEntity.ok(product);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(
            summary = "Create a new product",
            description = "Adds a new product to the in-memory list. Id, name, and price are required."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Validation failed (missing id, invalid name/price)")
    })
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {

        products.add(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    @Operation(
            summary = "Delete a product by id",
            description = "Removes a product from the in-memory list if it exists."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "Id of the product to delete", example = "1")
            @PathVariable Long id) {

        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }
}