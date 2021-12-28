package com.headless.ecommerce.controller;

import com.headless.ecommerce.domain.*;
import com.headless.ecommerce.dto.CategoryDto;
import com.headless.ecommerce.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.headless.ecommerce.service.CategoryService;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    private CatalogService catalogService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @PostMapping("/category")
    public Category saveCategory(@RequestBody CategoryDto categoryDto) {
        Category category = categoryService.saveCategory(createCategoryFromDto(categoryDto));
        saveCategoryAttributes(categoryDto, category);
        return category;
    }

    private Category createCategoryFromDto(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        Catalog catalog = catalogService.findCatalog(categoryDto.getCatalogId());
        category.setCatalog(catalog);
        return category;
    }

    private void saveCategoryAttributes(CategoryDto categoryDto, Category savedCategory) {
        categoryDto.getCategoryAttributes().forEach(attributes -> {
            CategoryAttributes categoryAttributes = new CategoryAttributes();
            categoryAttributes.setId(attributes.getId());
            categoryAttributes.setKey(attributes.getKey());
            categoryAttributes.setValue(attributes.getValue());
            categoryAttributes.setCategory(savedCategory);
            categoryService.saveCategoryAttributes(categoryAttributes);
        });
    }

    @PutMapping("/category")
    public Category updateCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        if (category.getName() != null) {
            category.setName(categoryDto.getName());
        }
        return categoryService.saveCategory(category);
    }
}
