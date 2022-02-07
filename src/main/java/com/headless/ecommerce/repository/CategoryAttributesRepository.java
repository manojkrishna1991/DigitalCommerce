package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.Category;
import com.headless.ecommerce.domain.CategoryAttributes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryAttributesRepository extends CrudRepository<CategoryAttributes, Long> {
    List<CategoryAttributes> findByCategory(Category category);

}
