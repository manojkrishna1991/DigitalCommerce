package com.headless.ecommerce.domain;

import javax.persistence.*;

@Entity
public class CatalogAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String key;
    private String value;
    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
