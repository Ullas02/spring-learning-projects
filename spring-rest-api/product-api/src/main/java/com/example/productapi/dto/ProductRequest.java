package com.example.productapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Payload accepted for creating or updating a Product.
 * Kept separate from {@link com.example.productapi.model.Product} so that
 * clients never control server-assigned fields such as the generated id.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    @Schema(description = "Name of the product", example = "Wireless Mouse")
    @NotBlank(message = "Product name must not be blank")
    private String name;

    @Schema(description = "Optional longer description", example = "Ergonomic wireless mouse with USB receiver")
    private String description;

    @Schema(description = "Unit price, must be greater than zero", example = "19.99")
    @Positive(message = "Product price must be greater than zero")
    private double price;

    @Schema(description = "Units in stock, zero or more", example = "100")
    @PositiveOrZero(message = "Quantity cannot be negative")
    private int quantity;

}
