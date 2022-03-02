package com.headless.ecommerce.controller;

import com.headless.ecommerce.service.SkuService;
import com.headless.ecommerce.dto.SkuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class SkuController {
    @Autowired
    private SkuService skuService;

    @PostMapping("/sku")
    public SkuDto saveSku(@RequestBody SkuDto skuDto) {
        return skuService.saveSku(skuDto);
    }

    @GetMapping("/sku/{skuId}")
    public SkuDto getSku(Long skuId) {
        return skuService.getSku(skuId);
    }

    @GetMapping("/sku/all")
    public List<SkuDto> getSkus() {
        return skuService.getSkus();
    }
}
