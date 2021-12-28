package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.CategoryAttributes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryAttributesRepository extends CrudRepository<CategoryAttributes, Long> {
}
