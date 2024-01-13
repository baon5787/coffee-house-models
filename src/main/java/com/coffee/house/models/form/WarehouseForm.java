package com.coffee.house.models.form;

import com.coffee.house.models.products.Warehouse;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class WarehouseForm {
	
	private String productName;
	
	private String sizeName;
	
	private int quantity;

	@Min(value = 1 , message = "Bạn phải nhập số lượng kích sản phẩm trên 1 sản phẩm")
	@Max(value = 1000, message = "Bạn phải nhập số lượng kích sản phẩm dưới 100 sản phẩm")
	private int updateQuantity;
	
	public static WarehouseForm getWarehouse(Warehouse warehouse) {
		return WarehouseForm.builder()
				.productName(warehouse.getProduct().getProductName())
				.sizeName(warehouse.getSize().getSizeName())
				.quantity(warehouse.getQuantity())
				.updateQuantity(warehouse.getUpdateQantity())
				.build();
	}
}
