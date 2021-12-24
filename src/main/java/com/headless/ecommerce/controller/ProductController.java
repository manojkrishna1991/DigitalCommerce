package com.headless.ecommerce.controller;

import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.dto.ProductDto;
import com.headless.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }

    @GetMapping("/product/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public Collection<ProductDto> getAllProduct() {
        return productService.getAllProduct();
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PutMapping("/product")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {

        return ResponseEntity.ok(productService.updateProduct(productDto));
    }
}
