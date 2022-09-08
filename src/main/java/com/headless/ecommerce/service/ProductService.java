package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.domain.ProductAttributes;
import com.headless.ecommerce.dto.ProductAttributeDto;
import com.headless.ecommerce.dto.ProductDto;
import com.headless.ecommerce.exception.ProductNotFoundException;
import com.headless.ecommerce.exception.productcatalog.CategoryNotFoundException;
import com.headless.ecommerce.mapper.ProductAttributeMapper;
import com.headless.ecommerce.mapper.ProductMapper;
import com.headless.ecommerce.repository.ProductAttributeRepository;
import com.headless.ecommerce.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;
    private final ProductAttributeRepository productAttributeRepository;
    private final ProductAttributeMapper productAttributeMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, CategoryService categoryService,
                          ProductAttributeRepository productAttributeRepository, ProductAttributeMapper productAttributeMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
        this.productAttributeRepository = productAttributeRepository;
        this.productAttributeMapper = productAttributeMapper;
    }

    public ProductDto saveProduct(ProductDto productDto) {
        Product product = createProduct(productDto);
        Optional<Category> category = getCategory(productDto);
        category.ifPresent(product::setCategory);
        return productMapper.productToProductDto(productRepository.save(product));
    }

    private Optional<Category> getCategory(ProductDto productDto) {
        try {
            Category category = categoryService.getCategory(productDto.getCategoryId());
            return Optional.of(category);
        } catch (CategoryNotFoundException categoryNotFoundException) {
            log.warn("Invalid  category provided for product creation");
        }
        return Optional.empty();
    }

    private Product createProduct(ProductDto productDto) {
        Optional<Category> category = getCategory(productDto);
        Product product = new Product();
        product.setName(productDto.getName());
        product.setId(productDto.getId());
        category.ifPresent(product::setCategory);
        return product;
    }

    public ProductDto updateProduct(ProductDto productDto) {
        Product product = findProductById(productDto.getId());
        productMapper.updateProductFromDto(productDto, product);
        return productMapper.productToProductDto(productRepository.save(product));
    }

    public Product findProductById(@NonNull Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (!product.isPresent()) {
            throw new ProductNotFoundException();
        }
        return product.get();
    }

    public ProductDto getProductById(@NonNull Long productId) {
        return productMapper.productToProductDto(findProductById(productId));
    }

    public List<ProductDto> getAllProduct() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).map(productMapper::productToProductDto).collect(Collectors.toList());
    }

    public Product deleteProduct(@NonNull Long productId) {
        Product product = findProductById(productId);
        productRepository.delete(product);
        return product;
    }

    public List<ProductAttributeDto> saveProductAttibutes(List<ProductAttributeDto> productAttributeDtoList, Long productId) {
        Product product = findProductById(productId);
        productAttributeDtoList.forEach(productAttributeDto -> {
            ProductAttributes productAttributes = new ProductAttributes();
            productAttributes.setId(productAttributeDto.getId());
            productAttributes.setKey(productAttributeDto.getKey());
            productAttributes.setValue(productAttributeDto.getValue());
            productAttributes.setProduct(product);
            productAttributeRepository.save(productAttributes);
        });
        return productAttributeRepository.findByProduct(product).stream().map(productAttributeMapper::productAttributesToProductAttributeDto).collect(Collectors.toList());

    }

    public List<ProductAttributeDto> getProductAttributes(Long productId) {
        Product product = findProductById(productId);
        return productAttributeRepository.findByProduct(product).stream().map(productAttributeMapper::productAttributesToProductAttributeDto).collect(Collectors.toList());
    }

}
