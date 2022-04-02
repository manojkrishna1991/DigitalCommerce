package com.headless.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;

@Entity(name = "LineItem")
public class LineItem {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = "sequence_name", value = "line_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1000"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )    @ApiModelProperty(hidden = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    @JsonIgnore
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
