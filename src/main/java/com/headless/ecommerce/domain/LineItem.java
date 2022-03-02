package com.headless.ecommerce.domain;

import javax.persistence.*;

@Entity(name = "LineItem")
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private CommerceOrder commerceOrder;

    @Column
    private Integer quantity;

    @Column
    private Long productId;

    @Column
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommerceOrder getOrder() {
        return commerceOrder;
    }

    public void setOrder(CommerceOrder commerceOrder) {
        this.commerceOrder = commerceOrder;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CommerceOrder getCommerceOrder() {
        return commerceOrder;
    }

    public void setCommerceOrder(CommerceOrder commerceOrder) {
        this.commerceOrder = commerceOrder;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
