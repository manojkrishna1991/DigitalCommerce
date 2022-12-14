package com.headless.ecommerce.domain;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "product")
public class Product {
    private String name;
    @Id
    @Column(name = "product_id")
    private Long id;
    @ManyToMany
    @JoinTable(name="product_relationship",
            joinColumns=@JoinColumn(name="product_id"),
            inverseJoinColumns=@JoinColumn(name="related_product_id")
    )
    private List<Product> products;

    @ManyToMany
    @JoinTable(name="product_relationship",
            joinColumns=@JoinColumn(name="related_product_id"),
            inverseJoinColumns=@JoinColumn(name="product_id")
    )
    private List<Product> relatedProducts;
    @OneToMany(mappedBy = "product")
    private Collection<Sku> skus;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @OneToMany(mappedBy = "product")
    private Collection<ProductAttributes> productAttributes;

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


    public List<Product> getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(List<Product> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public Collection<Sku> getSkus() {
        return skus;
    }

    public void setSkus(Collection<Sku> skus) {
        this.skus = skus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<ProductAttributes> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(Collection<ProductAttributes> productAttributes) {
        this.productAttributes = productAttributes;
    }
}
