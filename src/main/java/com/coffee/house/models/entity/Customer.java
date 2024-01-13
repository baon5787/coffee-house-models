package com.coffee.house.models.entity;

import java.util.Date;
import java.util.Set;

import com.coffee.house.models.enums.AuthenticationProvider;
import com.coffee.house.models.enums.Gender;
import com.coffee.house.models.orders.OrderInfo;
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
@Table(name = "customers")
public class Customer {
	
	@Id
	@Column(name = "customer_id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone_number")
	private String phone;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "photo_path")
	private String photoPath;
	
	@Column(name = "email_verified")
	private Boolean emailVerified;
	
	@Column(name = "joined_date")
	private Date joinedDate;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	@Column(name = "created_time")
	private Date createdTime;
	
	@Column(name = "lasted_time")
	private Date lastedTime;
	
	@Column(name = "account_non_locked")
	private Boolean accountNonLocked;

	@Column(name = "fail_attempt")
	private int failedAttempt;

	@Column(name = "lock_time")
	private Date lockTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "auth_provider")
	private AuthenticationProvider authProvider;
	
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "customer")
	private Set<CustomerToken> tokens;
	
	@OneToMany(mappedBy = "customerCartInfo", cascade = CascadeType.ALL)
	private Set<CartInfo> cartInfo;
	
	@OneToMany(mappedBy = "customerOrderInfo", fetch = FetchType.LAZY, 
			cascade =  CascadeType.DETACH, orphanRemoval = true)
	private Set<OrderInfo> orderInfos;
	
	@OneToOne(mappedBy = "customerAddress",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private AddressCustomer addressCustomer;
}
