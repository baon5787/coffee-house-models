package com.coffee.house.models.address;

import java.util.Set;

import com.coffee.house.models.entity.AddressUser;

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
@Table(name = "ward")
public class Ward {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ward_id")
	private int id;

	@Column(name = "_name")
	private String wardName;

	@Column(name = "_prefix")
	private String wardprefix;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;
	
	@OneToMany(mappedBy = "addressUserWard", cascade = CascadeType.ALL)
	private Set<AddressUser> addressUsers;
	
	
	public String getFullWard(){
		return wardprefix + " " + wardName;
	}
}
