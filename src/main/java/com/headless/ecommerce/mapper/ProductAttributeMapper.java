package com.headless.ecommerce.mapper;

import com.headless.ecommerce.domain.ProductAttributes;
import com.headless.ecommerce.dto.ProductAttributeDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductAttributeMapper {
    ProductAttributeMapper INSTANCE = Mappers.getMapper(ProductAttributeMapper.class);

    ProductAttributeDto productAttributesToProductAttributeDto(ProductAttributes productAttributes);

    ProductAttributes productAttributesDtoToProductAttributes(ProductAttributeDto productAttributeDto);
}
