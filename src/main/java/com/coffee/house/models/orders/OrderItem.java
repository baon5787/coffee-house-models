package com.coffee.house.models.orders;


import com.coffee.house.models.products.Product;
import com.coffee.house.models.products.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "order_items")
public class OrderItem {
	
	@Id
	@Column(name = "order_item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "size_price")
	private double sizePrice;
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private OrderInfo orderInfo;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product productOrderItem;
	
	@ManyToOne
	@JoinColumn(name = "size_id")
	private Size sizeOrderItem;
}
