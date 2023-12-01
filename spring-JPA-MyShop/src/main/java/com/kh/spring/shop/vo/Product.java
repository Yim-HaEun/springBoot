package com.kh.spring.shop.vo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product")
@Getter
@Setter
public class Product {
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productId_seq")
	@SequenceGenerator(name="productId_seq",sequenceName="productId_seq",allocationSize=1)
	private Long id;
	
	private String product_name;
	
	private String category;
	
	private String price;
	
	private String stock_quantity;
	
	private String description;
		
}

