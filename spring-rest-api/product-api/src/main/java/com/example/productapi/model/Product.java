package com.example.productapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain model for a Product.
 * <p>
 * In this module we hold products in memory (see {@link com.example.productapi.service.ProductService}).
 * In the next module this class becomes a JPA @Entity backed by a real database.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;

}
