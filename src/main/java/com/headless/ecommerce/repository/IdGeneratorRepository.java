package com.headless.ecommerce.repository;

import com.headless.ecommerce.domain.IdGenerator;
import org.springframework.data.repository.CrudRepository;

public interface IdGeneratorRepository extends CrudRepository<IdGenerator, String> {
    IdGenerator findByName(String name);
}
