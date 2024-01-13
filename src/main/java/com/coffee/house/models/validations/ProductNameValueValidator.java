package com.coffee.house.models.validations;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ProductNameValueValidator implements ConstraintValidator<ProductNameValue, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile("[!@#$%^&*_+\\-=\\[\\]{};':\"\\|,.<>\\/?]");
		boolean matcher = pattern.matcher(value).find();
		return !matcher;
	}

}
