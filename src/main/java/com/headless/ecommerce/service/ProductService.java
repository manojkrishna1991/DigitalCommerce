package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.exception.ProductNotFoundException;
import com.headless.ecommerce.generator.ProductIdGeneratorComponent;
import com.headless.ecommerce.repository.ProductRepository;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductIdGeneratorComponent productIdGeneratorComponent;

    public Product saveProduct(String name) {
        Product newProduct = new Product(name, productIdGeneratorComponent.generateIdInString());
        return mongoTemplate.save(newProduct);
    }

    public Product getProduct(@NonNull String id) {
        return mongoTemplate.findById(id, Product.class);
    }

    public Collection<Product> getAllProduct() {
        return mongoTemplate.findAll(Product.class);
    }

    public Product deleteProduct(@NonNull String id) {
        Product product = getProduct(id);
        DeleteResult deleteResult = mongoTemplate.remove(product);
        if (deleteResult.wasAcknowledged()) {
            return product;
        } else {
            throw new ProductNotFoundException();
        }
    }

    public Product updateProduct(Product produt) {
        return productRepository.save(produt);
    }
}
