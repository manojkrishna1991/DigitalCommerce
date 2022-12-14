package com.headless.ecommerce.dto;

import com.headless.ecommerce.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;
    private Long catalogId;
    private List<CategoryDto> childCategories;
}
