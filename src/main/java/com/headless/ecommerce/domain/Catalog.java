package com.headless.ecommerce.domain;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "catalog")
public class Catalog {
    @Id
    @Column(name = "catalog_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "catalog")
    private List<Category> categories;
    @OneToMany(mappedBy = "catalog")
    private Collection<CatalogAttributes> catalogAttributes;

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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Collection<CatalogAttributes> getCatalogAttributes() {
        return catalogAttributes;
    }

    public void setCatalogAttributes(List<CatalogAttributes> catalogAttributes) {
        this.catalogAttributes = catalogAttributes;
    }
}
