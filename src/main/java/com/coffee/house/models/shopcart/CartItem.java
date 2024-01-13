package com.coffee.house.models.shopcart;

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
@Table(name = "cart_items")
public class CartItem {
	
	@Id
	@Column(name = "cart_item_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartItemId;
	
	@Column(name = "quantity")
	private int quantity;
	
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product productCartItem;
	
	@ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private CartInfo cartInfo;
	
	@ManyToOne
	@JoinColumn(name = "size_id")
	private Size sizeCartItem;
	
}
