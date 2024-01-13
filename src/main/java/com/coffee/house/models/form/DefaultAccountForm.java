package com.coffee.house.models.form;

import com.coffee.house.models.enums.Gender;
import com.coffee.house.models.validations.ValueOfEnum;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class DefaultAccountForm {
	
	@ValueOfEnum(enumClass = Gender.class, message = "Chọn lại giới tính")
	private String gender;
	
	@NotNull(message = "Vui lòng chọn năm")
	@Min(value = 1900,message = "Vui lòng chọn năm lớn năm 1900")
	private int year;
	
	@NotNull(message = "Vui lòng chọn tháng")
	@Min(value = 1,message = "Vui lòng chọn tháng lớn tháng hoặc bằng tháng 1")
	@Max(value = 12,message = "Vui lòng chọn tháng nhỏ ngày hoặc bằng tháng 12")
	private int month;
	
	@NotNull(message = "Vui lòng chọn ngày")
	@Min(value = 1,message = "Vui lòng chọn tháng lớn ngày hoặc bằng ngày 1")
	private int day;
	
	@NotBlank(message = "Số điện thoại bị trống")
	@NotEmpty(message = "Số điện thoại bị rỗng")
	@Pattern(regexp = "^[0]{1}[0-9]{9}$", 
		message = "Số điện thoại chỉ có 10 số và bắt đầu bằng số 0")
	private String phone;
}
