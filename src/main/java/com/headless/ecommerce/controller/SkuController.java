package com.headless.ecommerce.controller;

import com.headless.ecommerce.dto.SkuAttributeDto;
import com.headless.ecommerce.dto.SkuDto;
import com.headless.ecommerce.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public SkuDto getSku(@PathVariable Long skuId) {
        return skuService.getSku(skuId);
    }

    @GetMapping("/sku/all")
    public List<SkuDto> getSkus() {
        return skuService.getSkus();
    }

    @PostMapping("/sku/{skuId}/skuAttributes")
    public List<SkuAttributeDto> saveSkuAttributes(@RequestBody List<SkuAttributeDto> skuAttributeDtos, @PathVariable Long skuId) {
        return skuService.saveSkuAttibutes(skuAttributeDtos, skuId);
    }

    @GetMapping("/sku/{skuId}/skuAttributes")
    public List<SkuAttributeDto> getSkuAttributes(@PathVariable Long skuId) {
        return skuService.getSkuAttributes(skuId);
    }

}
