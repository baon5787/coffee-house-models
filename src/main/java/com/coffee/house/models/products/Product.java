package com.coffee.house.models.products;

import java.util.Set;

import com.coffee.house.models.enums.Status;
import com.coffee.house.models.orders.OrderItem;
import com.coffee.house.models.shopcart.CartItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "products")
public class Product {
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "description")
	private String description;

	@Column(name = "default_image")
	private String image;

	@Column(name = "default_price")
	private double price;
	
	@Column(name = "product_status")
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "sku")
	private String sku;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
	private Set<Warehouse> warehouses;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productCartItem", 
			orphanRemoval = true)
	private Set<CartItem> cartItems;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productOrderItem", 
			orphanRemoval = true)
	private Set<OrderItem> orderItems;
	
}
