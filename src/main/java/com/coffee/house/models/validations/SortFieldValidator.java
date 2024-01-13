package com.coffee.house.models.validations;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SortFieldValidator implements ConstraintValidator<SortField, String>{

	private List<String> validNameFields;
	
	@Override
	public void initialize(SortField sortField) {
		this.validNameFields = Arrays.asList(sortField.nameFields());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) return true;
		return validNameFields.contains(value);
	}

}
