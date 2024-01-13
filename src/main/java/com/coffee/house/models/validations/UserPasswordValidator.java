package com.coffee.house.models.validations;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class UserPasswordValidator implements ConstraintValidator<UserPassword, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])^(?=.*[^A-Za-z0-9])");
		return pattern.matcher(value).find();
	}

}
