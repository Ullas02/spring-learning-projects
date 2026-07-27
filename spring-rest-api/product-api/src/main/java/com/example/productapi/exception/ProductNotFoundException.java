package com.example.productapi.exception;

/**
 * Thrown when a lookup, update, or delete is attempted for a product id
 * that doesn't exist. Mapped to HTTP 404 by {@link GlobalExceptionHandler}.
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product not found with id: " + id);
    }

}
