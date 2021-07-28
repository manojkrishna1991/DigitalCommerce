package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
