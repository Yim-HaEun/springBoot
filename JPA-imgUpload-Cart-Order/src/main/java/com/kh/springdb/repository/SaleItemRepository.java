package com.kh.springdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kh.springdb.model.vo.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem,Integer>{
	List<SaleItem> findSaleItemBySellerId(int sellerId);//판매자의 판매 물품들
	List<SaleItem> findAll();

}
