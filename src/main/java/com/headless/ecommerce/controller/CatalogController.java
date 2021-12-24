package com.headless.ecommerce.controller;

import com.headless.ecommerce.domain.Catalog;
import com.headless.ecommerce.dto.CatalogDto;
import com.headless.ecommerce.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @PostMapping("/catalog")
    public Catalog saveCatalog(@RequestBody CatalogDto catalogDto) {
        Catalog catalog = new Catalog();
        catalog.setName(catalogDto.getName());
        catalog.setId(catalogDto.getId());
        catalog.setCategories(catalogDto.getCategories());
        catalog.setCatalogAttributes(catalogDto.getCatalogAttributes());
        return catalogService.saveCatalog(catalog);
    }

    @GetMapping("/catalog/{id}")
    public Catalog getCatalog(@PathVariable Long id) {
        return catalogService.getCatalog(id);
    }
}
