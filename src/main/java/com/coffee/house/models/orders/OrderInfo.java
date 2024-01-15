package com.coffee.house.models.orders;

import java.util.Date;
import java.util.Set;

import com.coffee.house.models.coupon.Coupon;
import com.coffee.house.models.entity.Customer;
import com.coffee.house.models.entity.User;
import com.coffee.house.models.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "order_infos")
public class OrderInfo {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "shipping")
	private double shipping;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "discount")
	private double discount;
	
	@Column(name = "order_status")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@Column(name = "order_create")
	private Date orderCreate;
	
	@Column(name = "order_update")
	private Date orderUpdate;

	@Column(name = "order_note")
	private String orderNote;
	
	@OneToOne(mappedBy = "orderInfo",cascade = CascadeType.ALL)
	private PaymentDetail paymentDetail;
	
	@ManyToOne()
	@JoinColumn(name = "coupon_id", referencedColumnName = "coupon_id")
	private Coupon couponOrderInfo;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customerOrderInfo;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User userCartInfo;

	
	@OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderItem> items;
}
