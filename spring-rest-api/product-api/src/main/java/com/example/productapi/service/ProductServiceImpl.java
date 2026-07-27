package com.example.productapi.service;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.exception.ProductNotFoundException;
import com.example.productapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * In-memory implementation backed by a {@link ConcurrentHashMap}.
 * <p>
 * This is the Module 4 stand-in for persistence:
 * <pre>
 *   Controller -> Service -> In-Memory List
 * </pre>
 * In the next module this class is replaced by a Repository-backed
 * implementation talking to a real database:
 * <pre>
 *   Controller -> Service -> Repository -> Database
 * </pre>
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public List<Product> getAllProducts() {
        return List.copyOf(products.values());
    }

    @Override
    public Product getProductById(Long id) {
        Product product = products.get(id);
        if (product == null) {
            throw new ProductNotFoundException(id);
        }
        return product;
    }

    @Override
    public Product createProduct(ProductRequest request) {
        long id = idGenerator.incrementAndGet();
        Product product = new Product(
                id,
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getQuantity()
        );
        products.put(id, product);
        return product;
    }

    @Override
    public Product updateProduct(Long id, ProductRequest request) {
        Product existing = products.get(id);
        if (existing == null) {
            throw new ProductNotFoundException(id);
        }

        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setQuantity(request.getQuantity());

        return existing;
    }

    @Override
    public void deleteProduct(Long id) {
        Product removed = products.remove(id);
        if (removed == null) {
            throw new ProductNotFoundException(id);
        }
    }

}
