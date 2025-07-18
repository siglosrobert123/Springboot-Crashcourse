package com.example.demo.myfirstapi.repository;

import com.example.demo.myfirstapi.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    static ProductRepository productRepository;

    @BeforeAll
    static void setUp(){
        productRepository = new ProductRepository();
    }

    @Test
    void testFindAll(){
        List<Product> products = productRepository.findAll();
        assertFalse(products.isEmpty());
        assertEquals(3, products.size());
    }

    @Test
    void testFindById(){
        var product = productRepository.findById(1L);
        assertEquals("Laptop", product.get().getName());
        assertEquals(1200.00, product.get().getPrice());

        var nonExistentProduct = productRepository.findById(5L);
        assertFalse(nonExistentProduct.isPresent());
    }

    @Test
    void testSave(){
        var newProduct = new Product(null, "Monitor", 500.00);
        var savedProduct = productRepository.save(newProduct);
        assertNotNull(savedProduct.getId());
        assertTrue(productRepository.findAll().contains(savedProduct));

        savedProduct.setPrice(400.00);
        var updatedProduct = productRepository.save(savedProduct);
        assertEquals(400.00, updatedProduct.getPrice());
        assertTrue(productRepository.findAll().contains(updatedProduct));

        var nonExistentProduct = new Product(70L, "Snacks", 30.00);
        assertNotNull(nonExistentProduct.getId());
        var savedNonExistentProduct = productRepository.save(nonExistentProduct);
        assertEquals(savedNonExistentProduct, nonExistentProduct);
        assertFalse(productRepository.findAll().contains(savedNonExistentProduct));
    }

}