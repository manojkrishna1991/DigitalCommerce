package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.dto.ProductDto;
import com.headless.ecommerce.exception.ProductNotFoundException;
import com.headless.ecommerce.mapper.ProductMapper;
import com.headless.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);
        return productMapper.productToProductDto(productRepository.save(product));
    }

    public ProductDto updateProduct(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId()).get();
        if (product == null) {
            throw new ProductNotFoundException();
        }
        productMapper.updateProductFromDto(productDto, product);
        return productMapper.productToProductDto(productRepository.save(product));
    }

    public ProductDto getProductById(@NonNull Long id) {
        return productMapper.productToProductDto(productRepository.findById(id).get());
    }

    public List<ProductDto> getAllProduct() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).map(product -> productMapper.productToProductDto(product)).collect(Collectors.toList());
    }

    public Product deleteProduct(@NonNull Long id) {
        Product product = productRepository.findById(id).get();
        if (product != null) {
            productRepository.delete(product);
        } else {
            throw new ProductNotFoundException();
        }
        return product;
    }

}
