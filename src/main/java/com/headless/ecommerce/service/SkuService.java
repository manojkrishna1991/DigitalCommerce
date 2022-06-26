package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.domain.Sku;
import com.headless.ecommerce.dto.SkuDto;
import com.headless.ecommerce.exception.productcatalog.SkuNotFoundException;
import com.headless.ecommerce.mapper.SkuMapper;
import com.headless.ecommerce.repository.ProductRepository;
import com.headless.ecommerce.repository.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SkuService {

    @Autowired
    private SkuRepository skuRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private SkuMapper skuMapper;

    public SkuDto saveSku(SkuDto skuDto) {
        Sku sku = skuMapper.skuDtoToSku(skuDto);
        Product product = productService.findProductById(skuDto.getProductId());
        sku.setProduct(product);
        Sku savedSku = skuRepository.save(sku);
        return skuMapper.skuToSkuDto(savedSku);
    }

    public SkuDto getSku(Long skuId) {
        Optional<Sku> sku = skuRepository.findById(skuId);
        if (!sku.isPresent()) {
            throw new SkuNotFoundException();
        }
        return skuMapper.skuToSkuDto(sku.get());
    }

    public List<SkuDto> getSkus() {
        return StreamSupport.stream(skuRepository.findAll().spliterator(), false).map(sku -> skuMapper.skuToSkuDto(sku)).collect(Collectors.toList());

    }
}
