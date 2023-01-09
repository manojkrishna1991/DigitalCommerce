package com.headless.ecommerce.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity(name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    private Long id;
    private String name;
    private String version;
    private String externalId;
    private String description;
    private String metaTitle;
    private String metaDescription;
    private String metaKeywords;
    private Date createdAt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
