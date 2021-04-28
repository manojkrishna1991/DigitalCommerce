package com.headless.ecommerce.generator;

import com.headless.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This class is used to generate product id
 * @author Manoj Krishna
 */
@Component
public class ProductIdGenerator implements IdGenerator, InitializingBean {
    @Value("${productGenerator.name}")
    private String name;
    @Value("${productGenerator.seedId}")
    private Long seedId;
    private Long currentId;
    @Value("${productGenerator.batchSize}")
    private Long batchSize;
    @Autowired
    private ProductRepository productRepository;


    @Override public String generateId() {
        return null;
    }

    @Override public void afterPropertiesSet() throws Exception {

    }
}
