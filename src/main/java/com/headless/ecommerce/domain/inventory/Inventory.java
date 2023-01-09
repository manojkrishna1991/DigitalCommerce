package com.headless.ecommerce.domain.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.headless.ecommerce.domain.Channel;
import com.headless.ecommerce.domain.Sku;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Inventory {
	@Id
	@Column(name="inventory_id")
	private String id;
	private Long version;
	@OneToOne
	@JoinColumn(name="sku_id", referencedColumnName = "sku_id")
	private Sku sku;
	@OneToOne
	@JoinColumn(name = "channel_id",referencedColumnName = "channel_id")
	private Channel channel;

}
