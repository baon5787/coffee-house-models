package com.coffee.house.models.form;

import java.util.Date;

import com.coffee.house.models.coupon.Coupon;
import com.coffee.house.models.coupon.CouponCategory;
import com.coffee.house.models.enums.CouponStatus;
import com.coffee.house.models.enums.CouponType;
import com.coffee.house.models.helper.AppConstant;
import com.coffee.house.models.products.Product;
import com.coffee.house.models.validations.CouponExpired;
import com.coffee.house.models.validations.ValueOfEnum;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponForm {
	
	@NotNull(message = "Tên phiếu giảm giá bị null")
	@NotEmpty(message = "Tên phiếu giảm giá bị rỗng")
	private String name;

	@NotEmpty(message = "Mã giảm giá bị trống")
	@NotBlank(message = "Mã giảm giá bị khoảng trắng")
	@Pattern(regexp = "^[A-Z]{3}[\\w]+$", message = "Mã giảm giá phải có trên ba kí tự(ba kí tự đầu là chữ in hoa và còn lại số hoặc chữ in hoa)")
	private String code;

	private double price;

	private int condition;

	@CouponExpired(message = "Hạn sử dụng phiếu giảm giá lớn hơn thời gian hiện tại một ngày")
	private Date expired;

	@ValueOfEnum(enumClass = CouponStatus.class, message = "Vui lòng chọn trạng thái phiếu giảm giá")
	private String status;

	@ValueOfEnum(enumClass = CouponType.class, message = "Vui lòng chọn loại phiếu giảm giá")
	private String couponType;

	@NotEmpty(message = "Danh mục phiếu giảm giá bị rỗng")
	@Pattern(regexp = "^[0-9]*$", message = "Vui lòng chọn lại danh mục phiếu giảm giá")
	private String couponCategory;

	@Min(value = 1, message = "Số lượng phiếu giảm giá trong 1 ngày lớn hơn 0")
	@Max(value = 100, message = "Số lượng phiếu giảm giá trong 1 ngày nhở hơn 100")
	private int quantity;

	private String product;
	
	public static CouponForm getCoupon(Coupon coupon) {
		CouponForm couponForm = CouponForm.builder()
				.name(coupon.getName())
				.code(coupon.getCode())
				.price(coupon.getPrice())
				.condition(coupon.getCondition())
				.quantity(coupon.getQuantity())
				.expired(coupon.getExpired())
				.couponType(coupon.getCouponType().name())
				.status(coupon.getStatus().name())
				.couponCategory(String.valueOf(coupon.getCouponCategory().getId()))
				.build();
		if(coupon.getProductCoupon() != null) {
			couponForm.setProduct(String.valueOf(coupon.getProductCoupon().getId()));
		}else {
			couponForm.setProduct(String.valueOf(AppConstant.PRODUCT_NULL));
		}
		
		return couponForm;
	}

	public Coupon createCoupon(CouponCategory couponCategory, Product product) {
		Coupon coupon = Coupon.builder()
				.name(name)
				.code(code)
				.price(price)
				.condition(condition)
				.quantity(quantity)
				.expired(expired)
				.couponCategory(couponCategory)
				.couponType(CouponType.valueOf(couponType))
				.enabled(true)
				.status(CouponStatus.valueOf(status))
				.build();
		if (couponCategory.getSymblos().equals(AppConstant.COUPON_CATEGORY_PRODUCT)) {
			coupon.setProductCoupon(product);
		}

		return coupon;
	}

	public void updateCoupon(Coupon coupon, CouponCategory couponCategory, Product product) {
		coupon.setName(name);
		coupon.setCode(code);
		coupon.setPrice(price);
		coupon.setCondition(condition);
		coupon.setQuantity(quantity);
		coupon.setExpired(expired);
		coupon.setCouponCategory(couponCategory);
		coupon.setCouponType(CouponType.valueOf(couponType));
		coupon.setStatus(CouponStatus.valueOf(status));
		
		if(couponCategory.getSymblos().equals(AppConstant.COUPON_CATEGORY_PRODUCT)) {
			coupon.setProductCoupon(product);
		}
		
		if(couponCategory.getSymblos().equals(AppConstant.COUPON_CATEGORY_TOTAL)) {
			coupon.setProductCoupon(null);
		}
	}
}
