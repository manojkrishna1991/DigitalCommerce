package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
