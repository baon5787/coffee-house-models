package com.coffee.house.models.form;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleForm {
	
	@NotNull(message = "Vui lòng chọn quyền")
	private List<Integer> roles;
}
