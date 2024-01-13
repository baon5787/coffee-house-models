package com.coffee.house.models.enums;

public enum OrderStatus {
	SHIPPED, DELIVERED, PENDING, PROCESSING, CANCELLED;
	
	public String getName() {
		String status;
		
		switch (this) {
		case PENDING:{
			status = "Chờ xử lý";		
			break;
		}
		case PROCESSING:{
			status = "Đang xử lý";
			break;
		}
		case SHIPPED:{
			status = "Đang vận chuyển";		
			break;
		}
		case DELIVERED:{
			status = "Đã giao";		
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
