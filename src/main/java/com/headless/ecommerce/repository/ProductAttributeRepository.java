package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.Product;
import com.headless.ecommerce.domain.ProductAttributes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductAttributeRepository extends CrudRepository<ProductAttributes,Long> {
    List<ProductAttributes> findByProduct(Product product);
}
