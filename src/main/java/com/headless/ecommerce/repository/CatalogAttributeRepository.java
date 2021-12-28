package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.Catalog;
import com.headless.ecommerce.domain.CatalogAttributes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogAttributeRepository extends CrudRepository<CatalogAttributes, Long> {
    List<CatalogAttributes> findByCatalog(Catalog catalog);
}
