package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.vo.Cart;

public interface CartRepository extends JpaRepository <Cart,Integer>{
	Cart findByUserId(int id); //사용자 아이디를 바탕으로 해서 id주인의 카트를 조회하기위해 사용하는 메서드
	Cart findCartById(int id);//주어진 CartId를 바탕으로 카트 내용 조회
	Cart findCartByUserId(int id);//카트에서 cart를 중점으로 UserId를 검색해서 조회 

}
