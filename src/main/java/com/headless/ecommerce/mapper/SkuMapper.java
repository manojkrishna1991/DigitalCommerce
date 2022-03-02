package com.headless.ecommerce.mapper;

import com.headless.ecommerce.domain.Sku;
import com.headless.ecommerce.dto.SkuDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SkuMapper {
    SkuMapper INSTANCE = Mappers.getMapper(SkuMapper.class);

    SkuDto skuToSkuDto(Sku sku);

    Sku skuDtoToSku(SkuDto skuDto);
}
