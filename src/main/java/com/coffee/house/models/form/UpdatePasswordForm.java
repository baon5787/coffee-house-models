package com.coffee.house.models.form;

import com.coffee.house.models.validations.UserPassword;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordForm {
	
	@NotBlank(message = "Mật khẩu mới bị trống")
	@NotEmpty(message = "Mật khẩu mới bị rỗng")
	@UserPassword(message = "Mật khẩu mới phải có ít nhất 1 kí tự đặt biệt, số, chữ thường và chữ hoa")
	private String password;

	@NotBlank(message = "Mật khẩu mới bị trống")
	@NotEmpty(message = "Mật khẩu mới bị rỗng")
	@UserPassword(message = "Mật khẩu mới phải có ít nhất 1 kí tự đặt biệt, số, chữ thường và chữ hoa")
	private String passwordNew;
	
	private String passwordConfirmNew;
}
