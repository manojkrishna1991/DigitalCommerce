package com.headless.ecommerce.controller;

import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.service.CategoryService;


import java.util.List;

@RestController public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/{id}") public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @PostMapping("/category") public Category saveCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setProducts((List<Product>) categoryDto.getProducts());
        category.setChildCategories((List<Category>) categoryDto.getChildCategories());
        return categoryService.saveCategory(category);
    }

    @PutMapping("/category") public Category updateCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        if (category.getName() != null) {
            category.setName(categoryDto.getName());
        }
        if (!category.getProducts().isEmpty()) {
            category.setProducts((List<Product>) categoryDto.getProducts());
        }
        if (!category.getProducts().isEmpty()) {
            category.setChildCategories((List<Category>) categoryDto.getChildCategories());
        }
        return categoryService.saveCategory(category);
    }
}
