package com.coffee.house.models.enums;

public enum Status {

	PUBLISHED, INACTIVE;

	public String getName() {
		String status;
		
		switch (this) {
		case PUBLISHED: {
			status = "Đã duyệt";
			break;
		}
		case INACTIVE: {
			status = "Chưa duyệt";
			break;
		}

		default:
			status = "erro";
			break;
		}
		return status;
	}
}
