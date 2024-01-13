package com.coffee.house.models.form;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.coffee.house.models.enums.Status;
import com.coffee.house.models.products.Category;
import com.coffee.house.models.products.Product;
import com.coffee.house.models.products.Warehouse;
import com.coffee.house.models.validations.ValueOfEnum;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class ProductForm {
	
	@NotEmpty(message = "Vui lòng tên sản phẩm")
	@NotBlank(message = "Tên sản phẩm bị rỗng")
	@Pattern(regexp = "^[^(`!@#$%^&*_+={},-/\\.;':\"|<>?\\]\\[)]+$",
		message = "Tên sản phẩm không có kí tự đặt biệt")
	private String name;

	@NotBlank(message = "Mã sản phẩm bị rỗng")
	@NotEmpty(message = "Vui lòng nhập mã sản phẩm")
	@Pattern(regexp = "^[A-Z]*$", message = "Mã sản phẩm không có kí tự đặt biệt và số")
	private String sku;

	@Min(value = 30000, message = "Giá sản phẩm tối thiểu 30,000 đ")
	private double price;

	@NotNull(message = "Vui lòng nội dung sản phẩm")
	@NotBlank(message = "Nội dung sản phẩm bị rỗng")
	@Pattern(regexp = "^[^(`!@#$^&_+={};|<>\\~\\]\\[)]+$",
		message = "Nội dung sản phẩm không có một số kí tự đặt biệt nay (!@#$^&_+=[\\]{};<>/~)")
	private String description;

	@ValueOfEnum(enumClass = Status.class,message = "Chọn lại trạng thái sản phẩm")
	private String status;

	@NotEmpty(message = "Chọn loại sản phẩm")
	@Pattern(regexp = "^[0-9]*$", message = "Vui lòng chọn lại loại sản phẩm")
	private String category;

	private List<String> sizes;
	
	private String imageUrl;
	
	public static ProductForm getProduct(Product product) {
		return ProductForm.builder()
				.name(product.getProductName())
				.sku(product.getSku())
				.price(product.getPrice())
				.description(product.getDescription())
				.status(product.getStatus().name())
				.category(String.valueOf(product.getCategory().getCateogryId()))
				.imageUrl(product.getImage())
				.sizes(convertSizesToString(product))
				.build();
	}
	
	public Product createProduct(Category category) {
		return Product.builder()
				.productName(name)
				.sku(sku)
				.description(description)
				.price(price)
				.status(Status.valueOf(status))
				.enabled(true)
				.category(category)
				.build();
	}
	
	public void updateProduct(Product product, Category category) {
		product.setProductName(name);
		product.setSku(sku);
		product.setDescription(description);
		product.setPrice(price);
		product.setStatus(Status.valueOf(status));
		product.setCategory(category);
	}
	
	public static List<String> convertSizesToString(Product product) {
		return product.getWarehouses().stream()
				.map((productSize) -> String.valueOf(productSize.getPrimaryKey().getSizeId()))
				.collect(Collectors.toList());
	}
	
	public List<String> removeSizeIdMatch(Product product, String productNoSize){
		
		if(sizes.isEmpty() || sizes == null) return null;
		
		Map<String,String> mapSizes = sizes.stream()
				.collect(Collectors.toMap(String::toString, String::toString));
		//remove id size form match is size save
		for (Warehouse warehouse : product.getWarehouses()) {
			String idSize = String.valueOf(warehouse.getPrimaryKey().getSizeId());
			if(mapSizes.containsValue(idSize)) {
				mapSizes.remove(idSize);
			}
		}
		return mapSizes.keySet().stream()
				.collect(Collectors.toList());
	}
}
