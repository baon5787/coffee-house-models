package com.coffee.house.models.validations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ParamOfEnumValidator implements ConstraintValidator<ParamOfEnum, String>{
	
	private List<String> acceptedValues;

	@Override
	public void initialize(ParamOfEnum annotation) {
		acceptedValues = Stream.of(annotation.enumClass().getEnumConstants()).map(Enum::name)
				.collect(Collectors.toList());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) return true;

		return acceptedValues.contains(value.toString());
	}
}
