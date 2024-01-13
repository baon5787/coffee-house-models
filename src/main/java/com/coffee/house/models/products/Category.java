package com.coffee.house.models.products;

import java.util.List;

import com.coffee.house.models.enums.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cateogryId;

	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "category_status")
	@Enumerated(EnumType.STRING)
	private Status categoryStatus;

	@Column(name = "category_code")
	private String categoryCode;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
	private List<Product> products;
	
	@OneToOne
	@JoinColumn(name = "parent_id")
	private Category parent;
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Category> children;

}
