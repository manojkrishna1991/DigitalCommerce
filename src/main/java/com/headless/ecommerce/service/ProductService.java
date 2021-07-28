package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.exception.ProductNotFoundException;
import com.headless.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(String name) {
        Product newProduct = new Product();
        newProduct.setName(name);
        return productRepository.save(newProduct);
    }

    public Product getProduct(@NonNull Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getAllProduct() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Product deleteProduct(@NonNull Long id) {
        Product product = getProduct(id);
        if (product != null) {
            productRepository.delete(product);
        } else {
            throw new ProductNotFoundException();
        }
        return product;
    }

    public Product updateProduct(Product produt) {
        return productRepository.save(produt);
    }
}
