package com.coffee.house.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum PaymentStatus {
	PENDING, SUCCESS, CANCELLED;

	public String getName() {
		String status;

		switch (this) {
			case SUCCESS: {
				status = "Thành công";
				break;
			}
			case PENDING: {
				status = "Chờ thanh toán";
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

	public static Map<String, String> getListStateTranstionPayment() {
		// state transtion : PENDING -> SUCCESS
		Map<String, String> stateTranstions = new HashMap<>();

		stateTranstions.put(PaymentStatus.PENDING.getName(), PaymentStatus.PENDING.name());
		stateTranstions.put(PaymentStatus.SUCCESS.getName(), PaymentStatus.SUCCESS.name());
		return stateTranstions;
	}
}
