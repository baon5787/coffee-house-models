package com.coffee.house.models.form;

import java.util.List;
import java.util.Set;

import com.coffee.house.models.entity.Role;
import com.coffee.house.models.entity.User;
import com.coffee.house.models.enums.Gender;
import com.coffee.house.models.untils.Convert;
import com.coffee.house.models.validations.UserPassword;

import jakarta.validation.constraints.Email;
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
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserForm extends UserDetailsForm{
	
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
		
	@NotNull(message = "Vui lòng chọn quyền")
	private List<Integer> roles;
	
	
	public User createUser(Set<Role> roles, String passwordEncode) {
		return User.builder()
				.email(email)
				.firstName(getFirstName().trim())
				.lastName(getLastName().trim())
				.phone(getPhone())
				.dateOfBirth(Convert.stringToDate(getYear(), getMonth(), getDay()))
				.gender(Gender.valueOf(getGender()))
				.enabled(true)
				.emailVerified(true)
				.password(passwordEncode)
				.userRole(roles)
				.build();
	}
}
