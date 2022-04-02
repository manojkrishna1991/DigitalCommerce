package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.domain.CategoryAttributes;
import com.headless.ecommerce.dto.CategoryAttributesDto;
import com.headless.ecommerce.exception.productcatalog.CategoryNotFoundException;
import com.headless.ecommerce.mapper.CategoryAttributesMapper;
import com.headless.ecommerce.repository.CategoryAttributesRepository;
import com.headless.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryAttributesRepository categoryAttributesRepository;
    @Autowired
    private CategoryAttributesMapper categoryAttributesMapper;

    public Category getCategory(Long categoryId) {
        return findCategoryById(categoryId);
    }

    private Category findCategoryById(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (!category.isPresent()) {
            throw new CategoryNotFoundException();
        }
        return category.get();
    }

    public List<CategoryAttributesDto> saveCategoryAttributes(List<CategoryAttributesDto> categoryAttributesList, Long categoryId) {
        Category category = findCategoryById(categoryId);
        categoryAttributesList.forEach(categoryAttributesDto -> {
            CategoryAttributes categoryAttributes = new CategoryAttributes();
            categoryAttributes.setId(categoryAttributesDto.getId());
            categoryAttributes.setKey(categoryAttributesDto.getKey());
            categoryAttributes.setValue(categoryAttributesDto.getValue());
            categoryAttributes.setCategory(category);
            categoryAttributesRepository.save(categoryAttributes);
        });

        return categoryAttributesRepository.findByCategory(category).stream().map(categoryAttributes -> categoryAttributesMapper.categoryAttributesToCategoryAttributesDto(categoryAttributes)).collect(Collectors.toList());

    }

    public List<CategoryAttributesDto> getCategoryAttributes(@NonNull Long categoryId) {
        Category category = findCategoryById(categoryId);
        return categoryAttributesRepository.findByCategory(category).stream().map(categoryAttributes -> categoryAttributesMapper.categoryAttributesToCategoryAttributesDto(categoryAttributes)).collect(Collectors.toList());
    }


    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public void deleteAllCategory() {
        categoryRepository.deleteAll();
    }

    public List<Category> getAllCategory() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
