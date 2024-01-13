package com.coffee.house.models.form;

import com.coffee.house.models.enums.Status;
import com.coffee.house.models.products.Category;
import com.coffee.house.models.validations.ValueOfEnum;

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
public class CategoryForm {
	
	@NotEmpty(message = "Nhập vào tên loại sản phẩm")
	@NotNull(message = "Nhập vào tên loại sản phẩm")
	@Pattern(regexp = "^[^(0-9`!@#$%^&*()_+={},-/\\.;':\"|<>?\\]\\[)]+$",
		message = "Tên sản phẩm không có kí tự đặt biệt và số")
	private String name;
	
	@NotEmpty(message = "Nhập vào mã loại sản phẩm")
	@NotNull(message = "Nhập vào mã loại sản phẩm")
	@Pattern(regexp = "[A-Z]+$",message = "Mã loại sản phẩm không có kí tự đặt biệt và số")
	private String code;
	
	@ValueOfEnum(enumClass = Status.class,message = "Vui lòng chọn trạng thái sản phẩm")
	private String status;
	
	private String parent;
	
	// Parent
	public static CategoryForm  getParentCategory(Category category) {	
		return CategoryForm.builder()
				.name(category.getCategoryName())
				.code(category.getCategoryCode())
				.status(category.getCategoryStatus().name())
				.parent(null)
				.build();
	}
	
	public Category createParentCategory() {
		return Category.builder()
				.categoryName(name)
				.categoryCode(code)
				.enabled(true)
				.categoryStatus(Status.valueOf(status))
				.build();
	}
	
	public void updateParentCategory(Category parentCategory) {
		parentCategory.setCategoryName(name);
		parentCategory.setCategoryCode(code);
		parentCategory.setCategoryStatus(Status.valueOf(status));
	}
	
	//Sub
	public static CategoryForm getSubCategory(Category category) {
		return CategoryForm.builder()
				.name(category.getCategoryName())
				.code(category.getCategoryCode())
				.status(category.getCategoryStatus().name())
				.parent(String.valueOf(category.getParent().getCateogryId()))
				.build();
	}
	
	public Category createSubCategory(Category category) {
		return Category.builder()
				.categoryName(name)
				.categoryCode(code)
				.enabled(true)
				.categoryStatus(Status.valueOf(status))
				.parent(category)
				.build();
	}
	
	public void updateSubCategory(Category subCategory,Category parent) {
		subCategory.setCategoryName(name);
		subCategory.setCategoryCode(code);
		subCategory.setCategoryStatus(Status.valueOf(status));
		subCategory.setParent(parent);
	}
}
