package com.example.demo.myfirstapi.controller;

import com.example.demo.myfirstapi.model.Product; // Import your Product model
import com.example.demo.myfirstapi.repository.ProductRepository; // Import your ProductRepository
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // This annotation makes it a REST controller
public class ProductController {

    private final ProductRepository productRepository; // Declare the dependency

    // Constructor Injection: Spring will automatically provide ProductRepository here
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // We will add methods here in the next steps
    @GetMapping("/products") // Maps HTTP GET requests to /products
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // Call our repository to get all products
    }

    @GetMapping("/products/{id}") // {id} is a path variable
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // Find the product by ID using the repository
        Optional<Product> product = productRepository.findById(id);

        // Check if the product was found
        if (product.isPresent()) {
            // If found, return it with HTTP 200 OK
            return ResponseEntity.ok(product.get()); // .get() gets the Product from Optional
        } else {
            // If not found, return HTTP 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/products") // Maps HTTP POST requests to /products
    @ResponseStatus(HttpStatus.CREATED) // Optional: Returns 201 Created by default for POST success
    public Product createProduct(@RequestBody Product newProduct) {
        // newProduct object automatically populated from JSON in request body
        return productRepository.save(newProduct); // Save and return the saved product (with its new ID)
    }
}