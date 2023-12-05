package com.kh.springdb.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.*;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_seq")
	@SequenceGenerator(name="item_seq",sequenceName="item_seq",allocationSize=1)
	//primaryKey
	private int id;
	private String name;//상품이름 
	private String description;//상품설명 
	private int price;//상품가격 
	private int count;//판매개수 ]
	private int stockQuantity;//재고
	private boolean isSale;//상품상태(판매중인지 품절인지 체크해주는)
	
	//@ManyToOne //상품을 판매하는 판매자가 여러명일 수 있으므로 판매자가 누구인지 아이디를 넣어줘야함
	//판매자 한명이 여러개의 상품을 팔 수 있기때문에 판매자 1: 상품 N
	//@JoinColumn(name="admin_id")
	//private Admin admin;//판매자 아이디(admin) 
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "seller_id")
	private User seller; //판매자 아이디
	 
	@OneToMany(mappedBy ="item")
	private List<CartItem> cartItems = new ArrayList<>();
	//@OneToMany(mappedBy = "item")
    //private List<OrderItem> orderItems = new ArrayList<>();

    //@OneToMany(mappedBy = "item")
    //private List<SaleItem> saleItems = new ArrayList<>();
	
	private String imgName; // 이미지 파일명

    private String imgPath; // 이미지 조회 경로
   
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 상품 등록 날짜

	
    @PrePersist // DB에 INSERT 되기 직전에 실행. 즉 DB에 값을 넣으면 자동으로 실행됨
    public void createDate() {
        this.createDate = LocalDate.now();
	
    }
	
}
