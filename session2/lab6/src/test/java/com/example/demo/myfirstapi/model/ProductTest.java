package com.example.demo.myfirstapi.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;
    Product noIdProduct;

    @BeforeEach
    void setup(){
        product = new Product(1L, "Laptop", 1000);
        noIdProduct = new Product("Mouse", 250);
    }

    @Test
    void testGetId(){
        assertEquals(1L, product.getId());
    }

    @Test
    void testNullId(){
        assertEquals(1L, product.getId());
    }

    @Test
    void testGetName(){
        assertEquals("Laptop", product.getName());
    }

    @Test
    void testGetPrice(){
        assertEquals(1000, product.getPrice());
    }

    @Test
    void testSetId(){
        product.setId(2L);
        assertEquals(2L, product.getId());
    }

    @Test
    void testSetName(){
        product.setName("Mouse");
        assertEquals("Mouse", product.getName());
    }

    @Test
    void testSetPrice(){
        product.setPrice(200);
        assertEquals(200, product.getPrice());
    }

    @Test
    void testToString(){
        String expected = "Product{" +
                "id=" + 1L +
                ", name='" + "Laptop" + '\'' +
                ", price=" + 1000.0 +
                '}';
        assertEquals(expected, product.toString());
    }

    @Test
    void testEquals(){
        Product sameProduct = new Product(1L, "Laptop", 1000);
        assertTrue(product.equals(sameProduct));

        sameProduct.setId(2L);
        assertFalse(product.equals(sameProduct));

        sameProduct = null;
        assertFalse(product.equals(sameProduct));

        assertFalse(product.equals("String"));

        assertTrue(product.equals(product));
    }

    @Test
    void testHashCode(){
        Product newProduct = new Product(1L, "Laptop", 1000);
        assertEquals(newProduct.hashCode(), product.hashCode());
    }
}