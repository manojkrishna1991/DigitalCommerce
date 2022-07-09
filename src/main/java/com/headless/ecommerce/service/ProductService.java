package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.domain.ProductAttributes;
import com.headless.ecommerce.dto.ProductAttributeDto;
import com.headless.ecommerce.dto.ProductDto;
import com.headless.ecommerce.exception.ProductNotFoundException;
import com.headless.ecommerce.mapper.ProductAttributeMapper;
import com.headless.ecommerce.mapper.ProductMapper;
import com.headless.ecommerce.repository.ProductAttributeRepository;
import com.headless.ecommerce.repository.ProductRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
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
        Category category = categoryService.getCategory(productDto.getCategoryId());
        product.setCategory(category);
        return productMapper.productToProductDto(productRepository.save(product));
    }

    private Product createProduct(ProductDto productDto) {
        Category category = categoryService.getCategory(productDto.getCategoryId());
        Product product = new Product();
        product.setName(productDto.getName());
        product.setId(productDto.getId());
        product.setCategory(category);
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

}
