package com.coffee.house.models.entity;

import com.coffee.house.models.address.Ward;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "address_customers")
public class AddressCustomer {
	
	@Id
	@Column(name = "address_customers_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "road")
	private String road;
	
	@Column(name = "apartment_number")
	private String apartmentNumber;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customerAddress;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ward_id", referencedColumnName = "ward_id", nullable = false)
	private Ward addressCustomerWard;
	
	public String getFullAddress() {
		return apartmentNumber + ", " + road + ", " + addressCustomerWard.getFullWard() + ", "
		+ addressCustomerWard.getDistrict().getFullDistrict() + ", "
		+ addressCustomerWard.getDistrict().getProvince().getFullProvince();
	}
}
