package com.coffee.house.models.enums;

public enum CouponType {
	PERCENT,MONEY;
	
	public String getName() {
		String status;
		
		switch (this) {
			case PERCENT:{
				status = "Phần trăm";
				break;
			}
			case MONEY:{
				status = "Tiền";		
				break;
			}
			default:
				status = "erro";
				break;
		}				
		return status;
	}

}
