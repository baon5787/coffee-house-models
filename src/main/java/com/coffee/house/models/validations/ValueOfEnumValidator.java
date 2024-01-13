package com.coffee.house.models.validations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, String>{
	
	private List<String> acceptedValues;

	@Override
	public void initialize(ValueOfEnum annotation) {
		acceptedValues = Stream.of(annotation.enumClass().getEnumConstants()).map(Enum::name)
				.collect(Collectors.toList());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return Boolean.FALSE;
		}

		return acceptedValues.contains(value.toString());
	}

}
