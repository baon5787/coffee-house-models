package com.coffee.house.models.orders;

import java.util.Date;

import com.coffee.house.models.enums.PaymentStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "payment_details")
public class PaymentDetail {

	
	@Id
	@Column(name = "payment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "amount")
	private double total;

	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "payment_status")
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;	
	
	@Column(name = "payment_code")
	private String paymentCode;
	
	@Column(name = "payment_created", nullable = false)
	private Date paymentCreated;	
	
	@Column(name = "payment_complete", nullable =  false)
	private Date paymentComplete;		
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "order_id", unique = true)	
	private OrderInfo orderInfo;
}
