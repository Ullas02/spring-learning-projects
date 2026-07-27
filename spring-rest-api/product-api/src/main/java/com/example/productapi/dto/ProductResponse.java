package com.example.productapi.dto;

import com.example.productapi.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Shape returned to API consumers. Decoupling this from the internal
 * {@link Product} model means the internal representation can change
 * (e.g. when we move to a database entity) without breaking the contract.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public static ProductResponse fromEntity(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
    }

}
