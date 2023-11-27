package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.mapper.ProductMapper;
import com.kh.springdb.model.Product;

@Service
public class ProductService {
	
	//JPA
	//private ProductRepository productRepository;
	@Autowired
	private ProductMapper productMapper;
	public List<Product> getAllProduct(){
		
		return productMapper.getAllProducts();//"찾은 제품 모두 다 가지고 오는 메서드 추가";
		
	}

}
