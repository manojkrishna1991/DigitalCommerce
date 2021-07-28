package com.headless.ecommerce.domain;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "product")
public class Product {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;
    @OneToMany
    private List<Product> relatedProducts;
    @OneToMany(mappedBy = "product")
    private List<Sku> skus;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRelatedProducts(List<Product> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public Collection<Product> getRelatedProducts() {
        return relatedProducts;
    }

    public Collection<Sku> getSkus() {
        return skus;
    }

}
