package com.coffee.house.models.untils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Convert{
	
	public static final DateFormat DATEFORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String  dateToString(Date date) {
		return DATEFORMAT.format(date);
	}
	
	public static Date stringToDate( int year, int month, int day) {
		StringBuffer birthdayStr = new StringBuffer();
		birthdayStr.append(day).append("/").append(month).append("/").append(year);
		
		Date birthday = new Date();
		
		try {
			birthday = DATEFORMAT.parse(birthdayStr.toString());
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
		
		return birthday;
	}
	
	public static Calendar dateToCalendar(Date birthday) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthday);
		return calendar;
	}
}
