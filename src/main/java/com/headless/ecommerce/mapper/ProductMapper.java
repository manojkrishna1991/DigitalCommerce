package com.headless.ecommerce.mapper;

import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.dto.ProductDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mappings(@Mapping(target = "categoryId", source = "product.category.id"))
    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto productDto);

    void updateProductFromDto(ProductDto productDto, @MappingTarget Product product);
}
