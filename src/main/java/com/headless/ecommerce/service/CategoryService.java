package com.headless.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.headless.ecommerce.domain.Category;

@Service
public class CategoryService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Category getCategory(String id) {
        return mongoTemplate.findById(id, Category.class);
    }

    public Category saveCategory(Category category) {
        return mongoTemplate.save(category);
    }
}
