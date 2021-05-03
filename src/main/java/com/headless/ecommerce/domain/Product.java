package com.headless.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(value = "product")
public class Product {
    private String name;
    @Id
    @JsonProperty
    private String id;
    private Collection<Product> relatedProducts;
    private Collection<Sku> skus;

    public Product(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<Product> getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(Collection<Product> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public Collection<Sku> getSkus() {
        return skus;
    }

    public void setSkus(Collection<Sku> skus) {
        this.skus = skus;
    }
}
