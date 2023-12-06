package com.kh.springdb.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="item")
public class Item {
	//id name text price count stock isSoldout
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator="item_seq")
	@SequenceGenerator(name="item_seq",sequenceName="item_seq",allocationSize=1)
	
	private int id;
	private String name;//물건 이름
	private String text;//물건에대한 설명
	private String price;//가격
	private int count;//판매개수
	private int stock;//재고
	private int isSoldout;//상품 품절 유무
	
	//이미지 업로드를 위한 파일명, 이미지 경로, 상품 등록 날짜
	private String imgName;
	private String imgPath;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate createDate;
	
	
	@PrePersist //DB에 값을 넣을 때 자동으로 생성된 날짜가 들어감
	public void createDate() {
		this.createDate = LocalDate.now();
	}
	//판매자가 누구인지, 장바구니에 어떤 아이템이 들어있는지
}
