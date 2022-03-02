package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.CommerceOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<CommerceOrder,Long> {
}
