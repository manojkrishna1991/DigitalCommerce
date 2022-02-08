package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Sku;
import com.headless.ecommerce.dto.SkuDto;
import com.headless.ecommerce.exception.productcatalog.SkuNotFoundException;
import com.headless.ecommerce.repository.SkuRepository;
import com.headless.ecommerce.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkuService {

    @Autowired
    private SkuRepository skuRepository;
    @Autowired
    private SkuMapper skuMapper;

    public SkuDto saveSku(SkuDto skuDto) {
        Sku sku = skuMapper.skuDtoToSku(skuDto);
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
}
