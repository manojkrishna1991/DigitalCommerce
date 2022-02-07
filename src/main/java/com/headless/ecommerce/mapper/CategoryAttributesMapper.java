package com.headless.ecommerce.mapper;

import com.headless.ecommerce.domain.CategoryAttributes;
import com.headless.ecommerce.dto.CategoryAttributesDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryAttributesMapper {
    CategoryAttributesMapper INSTANCE = Mappers.getMapper(CategoryAttributesMapper.class);

    CategoryAttributesDto categoryAttributesToCategoryAttributesDto(CategoryAttributes categoryAttributes);

    CategoryAttributes categoryAttributesDtoToCategoryAttributes(CategoryAttributesDto categoryAttributesDto);
}
