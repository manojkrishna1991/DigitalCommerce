package com.headless.ecommerce.dto;

import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.domain.ProductAttributes;
import com.headless.ecommerce.domain.Sku;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class ProductDto {

    private String name;
    private Long id;
    private Collection<Product> relatedProducts;
    private Collection<Sku> skus;
    private CategoryDto category;
    private Collection<Attributes> productAttributes;

}
