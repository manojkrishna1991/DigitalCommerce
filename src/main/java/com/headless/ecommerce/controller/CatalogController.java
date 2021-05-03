package com.headless.ecommerce.controller;

import com.headless.ecommerce.domain.Catalog;
import com.headless.ecommerce.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @PostMapping("/catalog")
    public Catalog createCatalog(@RequestBody Catalog catalog) {
        return catalogService.createCatalog(catalog);
    }

    @GetMapping("/catalog/{id}")
    public Catalog getCatalog(@PathVariable String id) {
        return catalogService.getCatalog(id);
    }
}
