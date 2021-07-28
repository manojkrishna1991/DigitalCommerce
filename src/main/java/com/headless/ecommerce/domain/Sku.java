package com.headless.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sku")
public class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    @Column(name = "sku_id")
    private Long id;
    private String name;
    private Long quantity;
    private Double listPrice;
    private Double salePrice;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    @OneToMany(mappedBy = "sku")
    private List<SkuAttributes> skuAttributes;

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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }
}
