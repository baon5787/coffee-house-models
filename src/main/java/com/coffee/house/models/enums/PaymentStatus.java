package com.coffee.house.models.enums;

public enum PaymentStatus {
	PENDING, SUCCESS, CANCELLED;
	
	public String getName() {
		String status;
		
		switch (this) {
		case SUCCESS:{
			status = "Thành công";
			break;
		}
		case PENDING:{
			status = "Chờ thanh toán";		
			break;
		}
		case CANCELLED:{
			status = "Đã hủy";		
			break;
		}
		default:
			status = "erro";
			break;
		}				
		return status;
	}
	
}
