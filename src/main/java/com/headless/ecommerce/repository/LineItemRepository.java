package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.LineItem;
import org.springframework.data.repository.CrudRepository;

public interface LineItemRepository extends CrudRepository<LineItem,Long> {
}
