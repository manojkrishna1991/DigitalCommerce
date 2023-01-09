package com.headless.ecommerce.domain.profile;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.headless.ecommerce.domain.Channel;
import com.headless.ecommerce.domain.ProductAttributes;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;
	private String externalId;
    @Column
    private Long userId;
	private String country;
	private String title;
	private String salutation;
	private String firstName;
	private String lastName;
	private String streetName;
	private String streetNumber;
	private String additionalStreetInfo;
	private String postalCode;
	private String city;
	private String region;
	private String state;
	private String company;
	private String department;
	private String building;
	private String apartment;
	private String poBox;
	private String phone;
	private String mobile;
	private String email;
	private String fax;
	private String additionalAddressInfo;
	@OneToMany(mappedBy = "product")
	private Collection<ProductAttributes> productAttributes;
	@OneToOne(mappedBy = "address")
	private Channel channel;
	
}
