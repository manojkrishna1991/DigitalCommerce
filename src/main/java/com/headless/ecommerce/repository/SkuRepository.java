package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.Sku;
import org.springframework.data.repository.CrudRepository;

public interface SkuRepository extends CrudRepository<Sku, Long> {
}
