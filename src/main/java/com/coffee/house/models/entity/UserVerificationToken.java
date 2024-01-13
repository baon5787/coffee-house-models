package com.coffee.house.models.entity;

import java.util.Date;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="user_verification_tokens")
public class UserVerificationToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_verification_token_id")
	public Integer id;
    
	@Column(name = "user_verification_token",unique = true)
	public String token;
	
	@Column(name = "user_verification_token_expiry")
	private Date expiryDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User userVerificationToken;
}
