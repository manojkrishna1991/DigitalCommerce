package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.domain.Sku;
import com.headless.ecommerce.domain.SkuAttributes;
import com.headless.ecommerce.dto.SkuAttributeDto;
import com.headless.ecommerce.dto.SkuDto;
import com.headless.ecommerce.exception.ProductNotFoundException;
import com.headless.ecommerce.exception.productcatalog.SkuNotFoundException;
import com.headless.ecommerce.mapper.SkuAttributeMapper;
import com.headless.ecommerce.mapper.SkuMapper;
import com.headless.ecommerce.repository.SkuAttributeRepository;
import com.headless.ecommerce.repository.SkuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class SkuService {

    @Autowired
    private SkuRepository skuRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private SkuAttributeRepository skuAttributeRepository;
    @Autowired
    private SkuAttributeMapper skuAttributeMapper;

    public SkuDto saveSku(SkuDto skuDto) {
        Sku sku = skuMapper.skuDtoToSku(skuDto);
        Optional<Product> product = getProductById(skuDto);
        product.ifPresent(sku::setProduct);
        Sku savedSku = skuRepository.save(sku);
        return skuMapper.skuToSkuDto(savedSku);
    }

    private Optional<Product> getProductById(SkuDto skuDto) {
        try {
            Product product = productService.findProductById(skuDto.getProductId());
            return Optional.of(product);
        } catch (ProductNotFoundException productNotFoundException) {
            log.warn("Empty Product for the sku and its orphan");
        }
        return Optional.empty();
    }


    public SkuDto getSku(Long skuId) {
        Sku sku = findSkuById(skuId);
        return skuMapper.skuToSkuDto(sku);
    }

    public Sku findSkuById(Long skuId) {
        Optional<Sku> sku = skuRepository.findById(skuId);
        if (!sku.isPresent()) {
            throw new SkuNotFoundException();
        }
        return sku.get();
    }

    public List<SkuDto> getSkus() {
        return StreamSupport.stream(skuRepository.findAll().spliterator(), false).map(sku -> skuMapper.skuToSkuDto(sku)).collect(Collectors.toList());

    }

    public List<SkuAttributeDto> saveSkuAttibutes(List<SkuAttributeDto> skuAttributeDtoList, Long skuId) {
        Sku sku = findSkuById(skuId);
        skuAttributeDtoList.forEach(skuAttributeDto -> {
            SkuAttributes skuAttributes = new SkuAttributes();
            skuAttributes.setId(skuAttributeDto.getId());
            skuAttributes.setKey(skuAttributeDto.getKey());
            skuAttributes.setValue(skuAttributeDto.getValue());
            skuAttributes.setSku(sku);
            skuAttributeRepository.save(skuAttributes);
        });
        return skuAttributeRepository.findBySku(sku).stream().map(skuAttributeMapper::skuAttributeToSkuAttributeDto).collect(Collectors.toList());

    }

    public List<SkuAttributeDto> getSkuAttributes(@NonNull Long skuId) {
        Sku sku = findSkuById(skuId);
        return skuAttributeRepository.findBySku(sku).stream().map(skuAttributeMapper::skuAttributeToSkuAttributeDto).collect(Collectors.toList());
    }

}
