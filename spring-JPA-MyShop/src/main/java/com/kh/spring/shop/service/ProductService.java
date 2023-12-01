package com.kh.spring.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.shop.repository.ProductRepository;
import com.kh.spring.shop.vo.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	public Optional<Product> getProductById(Long id){
		return productRepository.findById(id);
	}
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	
	
}
