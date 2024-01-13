package com.coffee.house.models.entity;

import com.coffee.house.models.enums.TokenType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name ="user_tokens")
public class UserToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_token_id")
	public Integer id;

	@Column(name = "user_token",unique = true)
	public String token;

	@Enumerated(EnumType.STRING)
	@Column(name = "token_type")
	public TokenType tokenType;
	
	@Column(name = "refersh_user_token",unique = true)
	public String refershToken;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User user;
}
