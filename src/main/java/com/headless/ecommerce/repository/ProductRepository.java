package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
}
