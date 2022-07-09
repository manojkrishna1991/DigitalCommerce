package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.Sku;
import com.headless.ecommerce.domain.SkuAttributes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuAttributeRepository extends CrudRepository<SkuAttributes,Long> {
    List<SkuAttributes> findBySku(Sku sku);
}
