package com.coffee.house.models.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CouponExpiredValidator implements ConstraintValidator<CouponExpired, Date>{
	
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private final SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		Date date = new Date();
		String dateStr = simpleDateFormat.format(date);
		dateStr += " 23:59:59";
		
		try {
			Date currentDate = simpleDateTimeFormat.parse(dateStr);
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.DATE, 1);
			Date currentDatePluseOne = c.getTime();
			return value.compareTo(currentDatePluseOne) < 0 ? false : true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
