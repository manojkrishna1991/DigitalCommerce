package com.headless.ecommerce.mapper;

import com.headless.ecommerce.domain.Catalog;
import com.headless.ecommerce.dto.CatalogDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    CatalogDto catalogToCatalogDto(Catalog catalog);
    Catalog catalogDtoToCatalog(CatalogDto catalogDto);
}
