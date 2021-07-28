package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.Catalog;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<Catalog,Long> {
}
