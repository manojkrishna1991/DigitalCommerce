package com.headless.ecommerce.mapper;

import com.headless.ecommerce.domain.ProductAttributes;
import com.headless.ecommerce.domain.SkuAttributes;
import com.headless.ecommerce.dto.ProductAttributeDto;
import com.headless.ecommerce.dto.SkuAttributeDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SkuAttributeMapper {
    SkuAttributeMapper INSTANCE = Mappers.getMapper(SkuAttributeMapper.class);

    SkuAttributeDto skuAttributeToSkuAttributeDto(SkuAttributes skuAttributes);

    SkuAttributes skuAttributeDtoToSkuAttribute(SkuAttributeDto skuAttributeDto);
}
