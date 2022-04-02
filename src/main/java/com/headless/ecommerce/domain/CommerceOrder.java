package com.headless.ecommerce.domain;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "CommerceOrder")
public class CommerceOrder {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = "sequence_name", value = "order_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1000"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )
    @Column(name = "order_id")
    private Long id;

    @Column
    private Long orderNumber;

    @Column
    private String  customerId;

    @Column
    private String customerEmail;

    @Column
    private String anonymousId;

    @OneToMany(mappedBy = "commerceOrder",cascade = CascadeType.ALL)
    private List<LineItem> lineItem;;

    @Column
    private String orderState;

    @Column
    private Double totalPrice;

    @Column
    private LocalDate updatedTime;
    @Column
    private LocalDate createdTime;
    @Column
    private Long updatedBy;
    @Version
    @Column(name = "VERSION")
    private long version;

    @Column
    private LocalDate lastModifiedAt;
    @Column
    private  Integer lastModifiedBy;

    public LocalDate getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDate updatedTime) {
        this.updatedTime = updatedTime;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }


    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDate getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(LocalDate lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LineItem> getLineItem() {
        return lineItem;
    }

    public void setLineItem(List<LineItem> lineItem) {
        this.lineItem = lineItem;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAnonymousId() {
        return anonymousId;
    }

    public void setAnonymousId(String anonymousId) {
        this.anonymousId = anonymousId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
