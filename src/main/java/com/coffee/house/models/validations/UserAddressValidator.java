package com.coffee.house.models.validations;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class UserAddressValidator implements ConstraintValidator<UserAddress, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{2}[a-zA-Z0-9\\s\\/]+$");
		return pattern.matcher(value).find();
	}

}
