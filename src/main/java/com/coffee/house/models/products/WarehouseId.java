package com.coffee.house.models.products;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
@Embeddable
public class WarehouseId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8425649682785849677L;

	@Column(name = "size_id")
	private int sizeId;
	
	@Column(name = "product_id")
	private int productId;
}
