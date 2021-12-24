package com.headless.ecommerce.dto;

import com.headless.ecommerce.domain.CatalogAttributes;
import com.headless.ecommerce.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CatalogDto {
    private Long id;
    private String name;
    private List<Category> categories;
    private List<CatalogAttributes> catalogAttributes;
}
