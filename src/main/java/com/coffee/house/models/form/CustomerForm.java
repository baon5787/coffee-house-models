package com.coffee.house.models.form;

import com.coffee.house.models.entity.Customer;
import com.coffee.house.models.enums.Gender;
import com.coffee.house.models.untils.Convert;
import com.coffee.house.models.validations.UserPassword;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerForm extends DefaultAccountForm{
	
	@NotBlank(message = "Họ của nhân viên bị trống")
	@NotEmpty(message = "Họ của nhân viên bị rỗng")
	@Pattern(regexp = "^[^(0-9!@#$%^&*()_+={},-/\\.;':\"|<>?\\]\\[)]+$", 
		message = "Họ của nhân viên không có kí tự đặt biệt và số")
	private String fullName;
	
	@NotBlank(message = "Mật khẩu bị trống")
	@NotEmpty(message = "Mật khẩu bị rỗng")
	@UserPassword(message = "Mật khẩu phải có ít nhất 1 kí tự đặt biệt, số, chữ thường và chữ hoa")
	private String password;
	
	private String passwordConfirm;
	
	@NotBlank(message = "Email bị trống")
	@NotEmpty(message = "Email bị rỗng")
	@Email(message = "Vui lòng nhập lại email cho đúng định dạng")
	@Pattern(regexp = "^[\\w\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", 
		message = "Vui lòng nhập lại vì sai email theo yêu cầu (vd: bao@gmail.com")
	private String email;
	
	public Customer createCustomer(String passwordEncode) {
		return Customer.builder()
				.email(email)
				.fullName(fullName)
				.phone(getPhone())
				.dateOfBirth(Convert.stringToDate(getYear(), getMonth(), getDay()))
				.gender(Gender.valueOf(getGender()))
				.enabled(true)
				.emailVerified(false)
				.password(passwordEncode)
				.build();
	}
}
