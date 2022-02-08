package com.headless.ecommerce.controller;

import com.headless.ecommerce.service.SkuService;
import com.headless.ecommerce.dto.SkuDto;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SkuController {

    private SkuService skuService;

    @PostMapping("/sku")
    public SkuDto saveSku(@RequestBody SkuDto skuDto) {
        return skuService.saveSku(skuDto);
    }

    @GetMapping("/sku/{skuId}")
    public SkuDto getSku(Long skuId) {
        return skuService.getSku(skuId);
    }
}
