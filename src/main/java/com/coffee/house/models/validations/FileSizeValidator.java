package com.coffee.house.models.validations;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile>{
	
	private static final Integer MB = 1024*1024;

    private long maxSizeInMB;

	@Override
	public void initialize(FileSize fileSize) {
		this.maxSizeInMB= fileSize.maxSizeInMB();
	}

	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
		if(value==null) return true;

        return value.getSize() < maxSizeInMB*MB;
	}


}
