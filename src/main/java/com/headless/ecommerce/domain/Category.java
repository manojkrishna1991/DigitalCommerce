package com.headless.ecommerce.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(value = "category")
public class Category {
    @Id
    private String id;
    private String name;
    private Collection<Product> products;
    private Collection<Category> childCategories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public Collection<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Collection<Category> childCategories) {
        this.childCategories = childCategories;
    }
}
