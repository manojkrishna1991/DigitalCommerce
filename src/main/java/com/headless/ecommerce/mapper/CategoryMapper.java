package com.headless.ecommerce.mapper;

import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.dto.CatalogDto;
import com.headless.ecommerce.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mappings({
            @Mapping(target = "catalogId", source = "category.id"),
            @Mapping(target = "childCategories", source = "category.subCategories")
    })
    CategoryDto categoryToCategoryDto(Category category);

    Category categoryDtoToCatalogDto(CatalogDto catalogDto);
}
