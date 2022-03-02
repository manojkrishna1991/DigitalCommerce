package com.headless.ecommerce.mapper;

import com.headless.ecommerce.domain.CatalogAttributes;
import com.headless.ecommerce.dto.CatalogAttributesDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CatalogAttributesMapper {
    CatalogAttributesMapper INSTANCE = Mappers.getMapper(CatalogAttributesMapper.class);

    CatalogAttributesDto catalogAttributesToCatalogAttributesDto(CatalogAttributes catalogAttributes);
    CatalogAttributes catalogAttributesToCatalogAttributesDto(CatalogAttributesDto catalogAttributesDto);
}
