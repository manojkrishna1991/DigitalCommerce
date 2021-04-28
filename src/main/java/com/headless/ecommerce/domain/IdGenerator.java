package com.headless.ecommerce.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IdGenerator {
    private Long seed;
    private Long batchSize;
    private String name;

    public Long getSeed() {
        return seed;
    }

    public void setSeed(Long seed) {
        this.seed = seed;
    }

    public Long getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Long batchSize) {
        this.batchSize = batchSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
