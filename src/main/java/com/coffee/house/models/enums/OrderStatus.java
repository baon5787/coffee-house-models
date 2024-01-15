package com.coffee.house.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {
	SHIPPED, DELIVERED, PENDING, PROCESSING, CANCELLED;

	public String getName() {
		String status;

		switch (this) {
			case PENDING: {
				status = "Chờ xử lý";
				break;
			}
			case PROCESSING: {
				status = "Đang xử lý";
				break;
			}
			case SHIPPED: {
				status = "Đang vận chuyển";
				break;
			}
			case DELIVERED: {
				status = "Đã giao";
				break;
			}
			case CANCELLED: {
				status = "Đã hủy";
				break;
			}
			default:
				status = "erro";
				break;
		}
		return status;
	}

	public static Map<String, String> getListStateTranstionOrder() {
		// state transtion : PENDING -> PROCESSING -> SHIPPED -> DELIVERED
		Map<String, String> stateTranstions = new HashMap<>();

		stateTranstions.put(OrderStatus.PENDING.getName(), OrderStatus.PENDING.name());
		stateTranstions.put(OrderStatus.PROCESSING.getName(), OrderStatus.PROCESSING.name());
		stateTranstions.put(OrderStatus.SHIPPED.getName(), OrderStatus.SHIPPED.name());
		stateTranstions.put(OrderStatus.DELIVERED.getName(), OrderStatus.DELIVERED.name());
		return stateTranstions;
	}
}
