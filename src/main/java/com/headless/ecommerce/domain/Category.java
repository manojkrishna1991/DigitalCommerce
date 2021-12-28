package com.headless.ecommerce.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "cateory_id")
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="catalog_id")
    private Catalog catalog;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    @OneToMany
    private List<Category> childCategories;
    @OneToMany(mappedBy = "category")
    private List<CategoryAttributes> categoryAttributes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Collection<Category> getChildCategories() {
        return childCategories;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public List<CategoryAttributes> getCategoryAttributes() {
        return categoryAttributes;
    }

    public void setCategoryAttributes(List<CategoryAttributes> categoryAttributes) {
        this.categoryAttributes = categoryAttributes;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setChildCategories(List<Category> childCategories) {
        this.childCategories = childCategories;
    }
}
