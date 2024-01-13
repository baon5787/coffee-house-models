package com.coffee.house.models.enums;

public enum Gender {
	MALE, FEMALE, OTHER;
	
	public String getName() {
		String gender;
		if (this.equals(MALE)) {
			gender = "Nam";
		} else if (this.equals(FEMALE)) {
			gender = "Nữ";
		} else {
			gender = "Khác";
		}
		return gender;
	}

}
