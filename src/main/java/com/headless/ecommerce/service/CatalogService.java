package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Catalog;
import com.headless.ecommerce.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;

    public Catalog createCatalog(Catalog catalog) {

        return catalogRepository.save(catalog);
    }

    public Catalog getCatalog(@NonNull Long id) {
        return catalogRepository.findById(id).get();
    }
}
