package com.coffee.house.models.validations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE, TYPE_USE })
@Constraint(validatedBy = FileSizeValidator.class)
public @interface FileSize {
	
	Class<? extends Payload> [] payload() default{};
    Class<?>[] groups() default {};
    
    long maxSizeInMB() default 512;

    String message() default "Max file size exceed.";
}
