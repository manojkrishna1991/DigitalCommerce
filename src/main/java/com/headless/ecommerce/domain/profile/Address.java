package com.headless.ecommerce.domain.profile;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "addressId")
    private Long addressId;

    @Column
    private Long userId;

    @Column
    private String pinCode;

    @Column
    private String residingState;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String addressLineOne;

    @Column
    private String addressLineTwo;

    @Column
    private String LandMark;

    @Column
    private String addressType;

    @Column
    private Boolean defaultAddress;

    

}
