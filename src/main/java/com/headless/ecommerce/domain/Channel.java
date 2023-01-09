package com.headless.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.headless.ecommerce.domain.inventory.Inventory;
import com.headless.ecommerce.domain.profile.Address;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Channel {
	@Id
	@Column(name="channel_id")
	private String id;
	private Long version;
	private String name;
	private String description;
	@OneToOne
	@JoinColumn(name="address_id",referencedColumnName = "address_id")
	private Address address;
	@OneToOne(mappedBy = "channel")
	private Inventory inventory;
}
