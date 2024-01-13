package com.coffee.house.models.products;

import java.text.DecimalFormat;
import java.util.Set;

import com.coffee.house.models.orders.OrderItem;
import com.coffee.house.models.shopcart.CartItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "sizes")
public class Size {
	
	@Id
	@Column(name = "size_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "size_name")
	private String sizeName;

	@Column(name = "size_price")
	private double sizePrice;

	@Column(name = "size_code")
	private String sizeCode;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.DETACH,mappedBy = "size")
	private Set<Warehouse> warehouses;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sizeOrderItem", 
			orphanRemoval = true)
	private Set<OrderItem> orderItems;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sizeCartItem", 
			orphanRemoval = true)
	private Set<CartItem> cartItems;
		
	public String getPriceVND() {
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		return  " "  + formatter.format(sizePrice) + " đ";
	}

}
