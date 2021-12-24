package com.headless.ecommerce.dto;

import com.headless.ecommerce.domain.Catalog;
import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.domain.CategoryAttributes;
import com.headless.ecommerce.domain.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;
    private Catalog catalog;
    private Collection<Product> products;
    private Collection<Category> childCategories;
    private Collection<CategoryAttributes> categoryAttributes;
}
