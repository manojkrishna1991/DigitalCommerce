package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.domain.CategoryAttributes;
import com.headless.ecommerce.exception.productcatalog.CategoryNotFoundException;
import com.headless.ecommerce.repository.CategoryAttributesRepository;
import com.headless.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryAttributesRepository categoryAttributesRepository;

    public Category getCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new CategoryNotFoundException();
        }
        return category.get();
    }

    public void saveCategoryAttributes(CategoryAttributes categoryAttributes) {

        categoryAttributesRepository.save(categoryAttributes);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
