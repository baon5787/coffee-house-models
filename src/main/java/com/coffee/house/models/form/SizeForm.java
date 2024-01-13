package com.coffee.house.models.form;

import com.coffee.house.models.products.Size;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SizeForm {
	
	@NotNull(message = "Vui lòng nhập tên kích thước sản phẩm")
	@NotEmpty(message = "Vui lòng nhập tên kích thước sản phẩm")
	@Pattern(regexp = "^[^(0-9`!@#$%^&*()_+={},-/\\.;':\"|<>?\\]\\[)]+$",
		message = "Tên kích thước sản phẩm không có kí tự đặt biệt và số")
	private String name;
	
	@Min(value = 0, message = "Giá của kích thước sản phẩm trên 0 đồng")
	@Max(value = 200000, message = "Giá của kích thước sản phẩm dưới 2 trăm nghìn đồng")
	private double price;
	
	@NotNull(message = "Vui lòng nhập mã kích thước sản phẩm")
	@NotEmpty(message = "Vui lòng nhập mã kích thước sản phẩm")
	@Pattern(regexp = "^[A-Z]+$", message = "Mã kích thước sản phẩm chỉ có kí tự in hóa")
	private String code;
	
	public static SizeForm getSize(Size size) {
		return SizeForm.builder()
				.name(size.getSizeName())
				.code(size.getSizeCode())
				.price(size.getSizePrice())
				.build();
	}
	
	public Size createSize() {
		return Size.builder()
				.sizeName(name)
				.sizeCode(code)
				.sizePrice(price)
				.enabled(true)
				.build();
	}
	
	public void updateSize(Size size) {
		size.setSizeName(name);
		size.setSizeCode(code);
		size.setSizePrice(price);
	}
}
