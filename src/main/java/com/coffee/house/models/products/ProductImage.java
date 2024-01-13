package com.coffee.house.models.products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "product_images")
public class ProductImage {
	
	@Id
	@Column(name = "product_image_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "product_image_name")
	private String productImage;
	
	@Column(name = "product_image_url")
	private String productImageUrl;
	
	@ManyToOne()
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
}
