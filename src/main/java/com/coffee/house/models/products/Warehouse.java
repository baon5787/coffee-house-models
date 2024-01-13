package com.coffee.house.models.products;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "warehouses")
public class Warehouse {

	@EmbeddedId
	private WarehouseId primaryKey;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "uppdate_quantity")
	private int updateQantity;
	
	@Column(name = "warehouse_create")
	private Date warehouseCreate;
	
	@Column(name = "warehouse_update")
	private Date warehouseUpdate;
	
	@ManyToOne
	@MapsId("size_id")
	@JoinColumn(name = "size_id", referencedColumnName = "size_id")
	private Size size;
	
	@ManyToOne
	@MapsId("product_id")
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Product product;
}
