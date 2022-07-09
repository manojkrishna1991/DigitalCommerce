package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.domain.Sku;
import com.headless.ecommerce.domain.SkuAttributes;
import com.headless.ecommerce.dto.SkuAttributeDto;
import com.headless.ecommerce.dto.SkuDto;
import com.headless.ecommerce.exception.productcatalog.SkuNotFoundException;
import com.headless.ecommerce.mapper.SkuAttributeMapper;
import com.headless.ecommerce.mapper.SkuMapper;
import com.headless.ecommerce.repository.SkuAttributeRepository;
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
    @Autowired
    private SkuAttributeRepository skuAttributeRepository;
    @Autowired
    private SkuAttributeMapper skuAttributeMapper;

    public SkuDto saveSku(SkuDto skuDto) {
        Sku sku = skuMapper.skuDtoToSku(skuDto);
        Product product = productService.findProductById(skuDto.getProductId());
        sku.setProduct(product);
        Sku savedSku = skuRepository.save(sku);
        return skuMapper.skuToSkuDto(savedSku);
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

    public List<SkuAttributeDto> saveProductAttibutes(List<SkuAttributeDto> skuAttributeDtoList, Long skuId) {
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
}
