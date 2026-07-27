package com.example.productapi;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.exception.ProductNotFoundException;
import com.example.productapi.model.Product;
import com.example.productapi.service.ProductService;
import com.example.productapi.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTests {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl();
    }

    @Test
    void createProduct_assignsIdAndStoresProduct() {
        ProductRequest request = new ProductRequest("Keyboard", "Mechanical keyboard", 49.99, 10);

        Product created = productService.createProduct(request);

        assertNotNull(created.getId());
        assertEquals("Keyboard", created.getName());
        assertEquals(1, productService.getAllProducts().size());
    }

    @Test
    void getProductById_throwsWhenMissing() {
        assertThrows(ProductNotFoundException.class, () -> productService.getProductById(999L));
    }

    @Test
    void updateProduct_updatesFieldsOfExistingProduct() {
        Product created = productService.createProduct(new ProductRequest("Mouse", "Wired mouse", 9.99, 5));

        Product updated = productService.updateProduct(
                created.getId(), new ProductRequest("Mouse Pro", "Wireless mouse", 19.99, 3));

        assertEquals("Mouse Pro", updated.getName());
        assertEquals(19.99, updated.getPrice());
        assertEquals(3, updated.getQuantity());
    }

    @Test
    void deleteProduct_removesProductAndThrowsOnSecondDelete() {
        Product created = productService.createProduct(new ProductRequest("Monitor", "27-inch monitor", 199.99, 2));

        productService.deleteProduct(created.getId());

        assertThrows(ProductNotFoundException.class, () -> productService.deleteProduct(created.getId()));
    }

}
