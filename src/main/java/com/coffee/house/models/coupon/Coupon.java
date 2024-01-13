package com.coffee.house.models.coupon;

import java.util.Date;
import java.util.Set;

import com.coffee.house.models.enums.CouponStatus;
import com.coffee.house.models.enums.CouponType;
import com.coffee.house.models.orders.OrderInfo;
import com.coffee.house.models.products.Product;
import com.coffee.house.models.shopcart.CartInfo;

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
@Table(name = "coupons")
public class Coupon {
	
	@Id
	@Column(name = "coupon_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "coupon_name")
	private String name;

	@Column(name = "coupon_quantity")
	private int quantity;

	@Column(name = "coupon_code")
	private String code;

	@Column(name = "coupon_condition")
	private int condition;

	@Column(name = "coupon_price")
	private double price;
	
	@Column(name = "coupon_expired")
	private Date expired;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "coupon_status")
	private CouponStatus status;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "coupon_type")
	private CouponType couponType;
	
	@Column(name = "enabled")
	private boolean enabled;

	@ManyToOne
	@JoinColumn(name = "coupon_category_id")
	private CouponCategory couponCategory;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product productCoupon;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "couponOrderInfo")
	private Set<OrderInfo> orderInfos;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "couponCartInfo")
	private Set<CartInfo> cartInfos;
}
