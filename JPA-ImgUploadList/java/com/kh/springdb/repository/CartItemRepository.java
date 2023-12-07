package com.kh.springdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kh.springdb.model.vo.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Integer>{
	CartItem findByCartIdAndItemId(int cartId, int itemId); //CartId와 ItemId로 CartItem 찾는 메서드
	CartItem findCartItemById(int id); //Id값에 해당하는 아이템을 찾는 메서드
	List<CartItem> findCartItemByItemId(int id); //모든 카트에 담긴 아이템을 반환하는 리스트 

}
