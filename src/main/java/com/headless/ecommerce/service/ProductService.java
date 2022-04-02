package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.dto.ProductDto;
import com.headless.ecommerce.exception.ProductNotFoundException;
import com.headless.ecommerce.mapper.ProductMapper;
import com.headless.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryService categoryService;

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

    private Product findProductById(@NonNull Long productId) {
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
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).map(product -> productMapper.productToProductDto(product)).collect(Collectors.toList());
    }

    public Product deleteProduct(@NonNull Long productId) {
        Product product = findProductById(productId);
        productRepository.delete(product);
        return product;
    }

}
