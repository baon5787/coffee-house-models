package com.coffee.house.models.form;

import com.coffee.house.models.validations.UserPassword;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginForm {
	
	@NotEmpty(message = "Email bị rỗng")
	@Email(message = "Vui lòng nhập lại email cho đúng định dạng")
	@Pattern(regexp = "^[\\w\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", 
		message = "Vui lòng nhập lại vì sai email theo yêu cầu (vd: bao@gmail.com")
	private String email;
	
	@UserPassword(message = "Mật khẩu phải có ít nhất 1 kí tự đặt biệt, số, chữ thường và chữ hoa")
	private String password;
}
