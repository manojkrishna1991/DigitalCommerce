package com.headless.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkuDto {

    private Long id;
    private String name;
    private Long quantity;
    private Double listPrice;
    private Double salePrice;
    private Long productId;
}
