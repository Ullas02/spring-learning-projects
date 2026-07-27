package com.example.productapi.service;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.model.Product;

import java.util.List;

/**
 * Business logic contract for Product operations. The controller depends
 * on this interface, not the implementation, so the backing store can be
 * swapped later (e.g. for a Repository/database) without touching the
 * controller.
 */
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(ProductRequest request);

    Product updateProduct(Long id, ProductRequest request);

    void deleteProduct(Long id);

}
