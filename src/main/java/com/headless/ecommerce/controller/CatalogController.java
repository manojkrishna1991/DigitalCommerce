package com.headless.ecommerce.controller;

import com.headless.ecommerce.domain.Catalog;
import com.headless.ecommerce.dto.CatalogAttributesDto;
import com.headless.ecommerce.dto.CatalogDto;
import com.headless.ecommerce.mapper.CatalogMapper;
import com.headless.ecommerce.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private CatalogMapper catalogMapper;

    @PostMapping("/catalog")
    public CatalogDto saveCatalog(@RequestBody CatalogDto catalogDto) {
        Catalog catalog = catalogService.saveCatalog(catalogMapper.catalogDtoToCatalog(catalogDto));
        return catalogMapper.catalogToCatalogDto(catalog);
    }

    @GetMapping("/catalog/{id}")
    public CatalogDto getCatalog(@PathVariable Long id) {
        return catalogMapper.catalogToCatalogDto(catalogService.findCatalog(id));
    }

    @PostMapping("/catalog/{catalogID}/catalogAttributes")
    public List<CatalogAttributesDto> saveCatalogAttributes(@RequestBody List<CatalogAttributesDto> catalogAttributes, @PathVariable Long catalogID) {
        return catalogService.saveCatalogAttributes(catalogAttributes, catalogID);
    }

    @GetMapping("/catalog/{catalogID}/catalogAttributes")
    public List<CatalogAttributesDto> getCatalogAttributes(@PathVariable Long catalogID) {
        return catalogService.getCatalogAttributes(catalogID);
    }
}
