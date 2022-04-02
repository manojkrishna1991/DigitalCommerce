package com.headless.ecommerce.controller;

import com.headless.ecommerce.domain.Catalog;
import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.dto.CategoryAttributesDto;
import com.headless.ecommerce.dto.CategoryDto;
import com.headless.ecommerce.dto.CategoryRequestDto;
import com.headless.ecommerce.mapper.CategoryAttributesMapper;
import com.headless.ecommerce.mapper.CategoryMapper;
import com.headless.ecommerce.service.CatalogService;
import com.headless.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryAttributesMapper categoryAttributesMapper;

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long categoryId) {
        Category category = categoryService.getCategory(categoryId);
        return ResponseEntity.ok(categoryMapper.categoryToCategoryDto(category));
    }

    @PostMapping("/category")
    public CategoryDto saveCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        Category category = categoryService.saveCategory(createCategoryFromDto(categoryRequestDto));
        return categoryMapper.categoryToCategoryDto(category);
    }

    @PostMapping("/category/{categoryId}/categoryAttributes")
    public List<CategoryAttributesDto> saveCategoryAttributes(@RequestBody List<CategoryAttributesDto> categoryAttributesDto, @PathVariable Long categoryId) {
        return categoryService.saveCategoryAttributes(categoryAttributesDto, categoryId);
    }

    @GetMapping("/category/{categoryId}/categoryAttributes")
    public List<CategoryAttributesDto> getCategoryAttributes(@PathVariable Long categoryId) {
        return categoryService.getCategoryAttributes(categoryId);
    }

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/category/all")
    public ResponseEntity<Object> deleteCategory() {
        categoryService.deleteAllCategory();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/category/all")
    public ResponseEntity<Object> getAllCategory() {
        List<Category> categories = categoryService.getAllCategory();
        List<CategoryDto> categoryDtos = categories.stream().map(category -> categoryMapper.categoryToCategoryDto(category)).collect(Collectors.toList());
        return ResponseEntity.ok(categoryDtos);
    }

    private Category createCategoryFromDto(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setId(categoryRequestDto.getId());
        category.setName(categoryRequestDto.getName());
        Catalog catalog = catalogService.findCatalog(categoryRequestDto.getCatalogId());
        category.setCatalog(catalog);
        return category;
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
