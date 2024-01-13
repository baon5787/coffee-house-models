package com.coffee.house.models.enums;

public enum CouponStatus {
	PUBLISHED,INACTIVE,EXPIRED;
	
	public String getName() {
		String status;
		
		switch (this) {
			case PUBLISHED:{
				status = "Đã duyệt";
				break;
			}
			case INACTIVE:{
				status = "Chưa duyệt";		
				break;
			}
			case EXPIRED:{
				status = "Hết hạn";		
				break;
			}
			default:
				status = "erro";
				break;
		}				
		return status;
	}

}
