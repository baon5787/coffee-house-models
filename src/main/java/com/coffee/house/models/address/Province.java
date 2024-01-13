package com.coffee.house.models.address;

import java.util.Set;

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
@Table(name = "province")
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "province_id")
	private int id;

	@Column(name = "_name")
	private String name;
	
	@Column(name = "_prefix")
	private String prefix;

	@Column(name = "_code")
	private String code;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "province")
	private Set<District> districts;
	
	public String getFullProvince(){
		return prefix + " " + name;
	}
}
