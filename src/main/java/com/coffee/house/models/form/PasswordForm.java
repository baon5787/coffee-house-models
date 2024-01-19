package com.coffee.house.models.form;

import com.coffee.house.models.validations.UserPassword;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class PasswordForm {
	
	@NotBlank(message = "Mật khẩu mới bị trống")
	@NotEmpty(message = "Mật khẩu mới bị rỗng")
	@UserPassword(message = "Mật khẩu mới phải có ít nhất 1 kí tự đặt biệt, số, chữ thường và chữ hoa")
	private String passwordNew;
	
	private String passwordConfirmNew;
}
