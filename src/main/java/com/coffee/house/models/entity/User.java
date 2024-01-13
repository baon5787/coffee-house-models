package com.coffee.house.models.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.coffee.house.models.enums.Gender;
import com.coffee.house.models.enums.Roles;
import com.coffee.house.models.orders.OrderInfo;

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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "photo_path")
	private String photoPath;
	
	@Column(name = "photo_name")
	private String photoName;
	
	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "email_verified")
	private boolean emailVerified;

	@Column(name = "phone_number")
	private String phone;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	
	@Column(name = "joined_date")
	private Date joinedDate;

	@Column(name = "account_non_locked")
	private boolean accountNonLocked;

	@Column(name = "failed_attempt")
	private int failedAttempt;

	@Column(name = "lock_time")
	private Date lockTime;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(name = "users_roles", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> userRole;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "user")
	private Set<UserToken> tokens;
	
	@OneToOne(mappedBy = "userVerificationToken")
	private UserVerificationToken userVerificationToken;
	
	@OneToMany(mappedBy = "userCartInfo", fetch = FetchType.LAZY, cascade =  CascadeType.DETACH, 
			orphanRemoval = true)
	private Set<OrderInfo> orderInfos;
	
	@OneToOne(mappedBy = "userAddress",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private AddressUser addressUser;
	
	public String getFullName(){
		return firstName + " " + lastName;
	}
		
	public List<Integer> getRoles(){
		if(userRole.isEmpty()) return null;
		
		return userRole.stream()
				.map((role) -> role.getId())
				.collect(Collectors.toList());
	};
	
	public Set<String> getRoleName(){
		if(userRole.isEmpty()) return null;
		
		return userRole.stream()
				.map((role) -> role.getName())
				.collect(Collectors.toSet());
	}
	
	public boolean isRoleAdmin(){
		if(userRole.isEmpty()) return false;
					
		return userRole.stream()
				.anyMatch(role -> role.getName().equals(Roles.ADMIN.name()));
	};
}
