package com.coffee.house.models.shopcart;

import java.util.List;

import com.coffee.house.models.coupon.Coupon;
import com.coffee.house.models.entity.Customer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "cart_infos")
public class CartInfo {
	
	@Id
	@Column(name = "cart_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartInfoId;
	
	@OneToMany(mappedBy = "cartInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItem> items;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customerCartInfo;
	
	@ManyToOne()
	@JoinColumn(name = "coupon_id", referencedColumnName = "coupon_id")
	private Coupon couponCartInfo;
}
