package com.kh.spring.shop.vo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {
	//데이터베이스에 주문 정보를 저장하기위한 클래스
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderId_seq")
	@SequenceGenerator(name="orderId_seq",sequenceName="orderId_seq", allocationSize=1)
	private Long id;
	//누가 주문했는지
	//결제를 얼마나 했는지 
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	private int quantity;//제품의 주문 수량

}
/*
 @joinColumn(name="조인하고자하는 컬럼명") 외래키(Foreign Key)
 데이터베이스에 테이블로 존재하는 객체를 작성
  
 private int quantity = 해당 제품의 수량을 표현
 @ManyToOne
 다대일(N:1) 관계를 설정하는 어노테이션
 주문이 하나의 제품에 속하는 경우 product_id값이 중복으로 들어갈 수 있음을 나타내기 위해 N:1이라는 설정을 함
 
 
  */
