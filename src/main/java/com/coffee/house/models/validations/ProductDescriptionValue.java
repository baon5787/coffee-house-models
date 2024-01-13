package com.coffee.house.models.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductDescriptionValueValidator.class)
public @interface ProductDescriptionValue {
	
	String message() default "{ProductDescriptionValue.invalid}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default {};
}