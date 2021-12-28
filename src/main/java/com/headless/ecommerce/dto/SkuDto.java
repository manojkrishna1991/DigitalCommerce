package com.headless.ecommerce.dto;

import com.headless.ecommerce.domain.SkuAttributes;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class SkuDto {

    private Long id;
    private String name;
    private Long quantity;
    private Double listPrice;
    private Double salePrice;
    private ProductDto product;
    private List<Attributes> skuAttributes;
}
