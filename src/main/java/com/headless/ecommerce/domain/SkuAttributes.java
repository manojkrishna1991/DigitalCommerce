package com.headless.ecommerce.domain;

import javax.persistence.*;

@Entity
public class SkuAttributes {
    @Id
    private Long id;
    private String key;
    private String value;
    @ManyToOne
    @JoinColumn(name = "sku_id")
    private Sku sku;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }
}
