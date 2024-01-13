package com.coffee.house.models.form;

import java.util.Calendar;

import com.coffee.house.models.address.Ward;
import com.coffee.house.models.entity.AddressUser;
import com.coffee.house.models.entity.User;
import com.coffee.house.models.enums.Gender;
import com.coffee.house.models.untils.Convert;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class UserDetailsForm extends DefaultAccountForm {
	
	@NotBlank(message = "Họ của nhân viên bị trống")
	@NotEmpty(message = "Họ của nhân viên bị rỗng")
	@Pattern(regexp = "^[^(0-9!@#$%^&*()_+={},-/\\.;':\"|<>?\\]\\[)]+$", 
		message = "Họ của nhân viên không có kí tự đặt biệt và số")
	private String firstName;
	
	@NotBlank(message = "Tên của nhân viên bị trống")
	@NotEmpty(message = "Tên của nhân viên bị rỗng")
	@Pattern(regexp = "^[^(0-9!@#$%^&*()_+={},-/\\.;':\"|<>?\\]\\[)]+$", 
		message = "Tên của nhân viên không có kí tự đặt biệt và số")
	private String lastName;
	

	@NotEmpty(message = "Tỉnh/Thành phố bị rỗng")
	@NotBlank(message = "Tỉnh/Thành phố bị trống")
	private String phovine;
	
	@NotEmpty(message = "Quận/Huyện bị rỗng")
	@NotBlank(message = "Quận/Huyện bị trống")
	private String district;
	
	@NotEmpty(message = "Phường/Xã bị rỗng")
	@NotBlank(message = "Phường/Xã bị trống")
	private String ward;
	
	@NotEmpty(message = "Số nhà bị rỗng")
	@NotBlank(message = "Số nhà bị trống")
	@Size(min = 1, max = 30, message = "Số nhà không vượt quá 30 kí tự")
	@Pattern(regexp = "^[0-9\\/]+$", message = "Số nhà không nên chứa các kí tự hoặc các kí tự đặc biệt trừ(/)")
	private String apartmentNumber;
	
	@NotEmpty(message = "Đường bị rỗng")
	@NotBlank(message = "Đường bị trống")
	@Size(min = 1, max = 80, message = "Đường không vượt quá 80 kí tự")
	@Pattern(regexp = "^[^(!@#$%^&*()_+={},\\.;':\"|<>?\\]\\[)]+$", message = "Đường không nên chứa các kí tự đặc biệt trừ(/-)")
	private String road;
	
	private String avater;
	
	
	public static UserDetailsForm getUserDetails(User user) {
		
		Calendar calendar = Convert.dateToCalendar(user.getDateOfBirth());
		
		UserDetailsForm form =  UserDetailsForm.builder()
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.year(calendar.get(Calendar.YEAR))
				.month(calendar.get(Calendar.MONTH) + 1) // Calendar.MONTH 0-11
				.day(calendar.get(Calendar.DATE))
				.phone(user.getPhone())
				.gender(user.getGender().name())
				.avater(user.getPhotoPath())
				.build();
		
		if(user.getAddressUser() != null) {
			
			AddressUser address = user.getAddressUser();
			
			form.setApartmentNumber(address.getApartmentNumber());
			form.setRoad(address.getRoad());
			form.setWard(address.getAddressUserWard().getWardName());
			form.setDistrict(address.getAddressUserWard().getDistrict().getDistrictName());
			form.setPhovine(address.getAddressUserWard().getDistrict().getProvince().getCode());
		}

		return form;
	}
	
	
	public static UserDetailsForm createUserDetails(User user) {
		
		Calendar calendar = Convert.dateToCalendar(user.getDateOfBirth());

		return UserDetailsForm.builder()
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.year(calendar.get(Calendar.YEAR))
				.month(calendar.get(Calendar.MONTH) + 1) // Calendar.MONTH 0-11
				.day(calendar.get(Calendar.DATE))
				.phone(user.getPhone())
				.gender(user.getGender().name())
				.avater(user.getPhotoPath())
				.build();
	}
	
	public void updateUser(Ward ward, User user) {
		user.setLastName(lastName.trim());
		user.setFirstName(firstName.trim());
		user.setPhone(getPhone());
		user.setGender(Gender.valueOf(getGender()));
		user.setDateOfBirth(Convert.stringToDate(getYear(), getMonth(), getDay()));
		user.getAddressUser().setApartmentNumber(apartmentNumber.trim());
		user.getAddressUser().setRoad(road.trim());
		user.getAddressUser().setAddressUserWard(ward);
	}
}
