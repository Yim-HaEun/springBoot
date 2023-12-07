package com.kh.springdb.service;

import org.springframework.stereotype.Service;

import com.kh.springdb.model.vo.Sale;
import com.kh.springdb.model.vo.User;
import com.kh.springdb.repository.ItemRepository;
import com.kh.springdb.repository.SaleItemRepository;
import com.kh.springdb.repository.SaleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleService {
	private final SaleRepository saleRepository;
	private final SaleItemRepository saleItemRepository;
	private final ItemRepository itemRepository;
	
	//회원가입 하면 판매자 당 판매내역 하나 생성
	public void createSale(User user) {
		Sale sale = Sale.createSale(user);
		saleRepository.save(sale);
	}

}
