package com.headless.ecommerce.dto;

import com.headless.ecommerce.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryRequestDto {

    private Long id;
    private String name;
    private Long catalogId;
}
