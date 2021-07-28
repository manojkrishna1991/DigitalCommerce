package com.headless.ecommerce.generator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This class is used to generate product id
 *
 * @author Manoj Krishna
 */
@Component
public class ProductIdGeneratorComponent implements IdGeneratorComponent {
    @Value("${productGenerator.name}")
    private String name;
    @Value("${productGenerator.seedId}")
    private Long seedId;
    private Long currentId;
    @Value("${productGenerator.batchSize}")
    private Long batchSize;


    @Override
    public Long generateId() {
        Long currentId = getCurrentId();
        currentId++;
        setCurrentId(currentId);
        return currentId;
    }


    @Override
    public String generateIdInString() {
        return getCurrentId().toString();
    }


    public Long getCurrentId() {
        return currentId;
    }

    public void setCurrentId(Long currentId) {
        this.currentId = currentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSeedId() {
        return seedId;
    }

    public void setSeedId(Long seedId) {
        this.seedId = seedId;
    }

    public Long getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Long batchSize) {
        this.batchSize = batchSize;
    }
}
