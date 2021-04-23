package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Product saveProduct(String name) {
        Product newProduct = new Product(name, UUID.randomUUID().toString());
        return mongoTemplate.save(newProduct);
    }

    public Product getProduct(String id) {
        return mongoTemplate.findById(id, Product.class);
    }
}
