package com.headless.ecommerce.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "category")
public class Category {
    @Id
    @Column(name = "cateory_id")
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;
    @OneToMany(mappedBy = "category", cascade = {CascadeType.ALL})
    private List<Product> products;
    @ManyToMany
    @JoinTable(name="category_relationship",
            joinColumns=@JoinColumn(name="category_id"),
            inverseJoinColumns=@JoinColumn(name="subcategory_id")
    )
    private List<Category> categories;

    @ManyToMany
    @JoinTable(name="category_relationship",
            joinColumns=@JoinColumn(name="subcategory_id"),
            inverseJoinColumns=@JoinColumn(name="category_id")
    )
    private List<Category> subCategories;

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


    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
