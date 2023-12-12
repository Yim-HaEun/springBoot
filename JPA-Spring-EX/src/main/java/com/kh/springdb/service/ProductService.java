package com.kh.springdb.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.Product;
import com.kh.springdb.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;
	
	public List<Product> allProductView(){
		return productRepository.findAll();
	}
	//pagination add
	public Page<Product> getList(int page){
		
		Pageable pageable = PageRequest.of(page, 1);//페이지마다 보여줄 목록 갯수
		return productRepository.findAll(pageable);
	}
	
	public void saveProduct(Product product, MultipartFile imgFile) throws IllegalStateException, IOException {
		//이미지 파일 이름 가져오기
		String OriginName = imgFile.getOriginalFilename();
		String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/img";
		
		File saveFile = new File(projectpath, OriginName);
		//MultipartFile에 File로 읽어온 이미지 파일을 저장하기위해 변환
		imgFile.transferTo(saveFile);
		product.setImgName(OriginName); //가져온 파일 이름 원본 저장
		product.setImgPath("/img/" +OriginName); //경로 저장을 DB에 작성해주기
		productRepository.save(product);
	}
	//상품 상세페이지나 수정하기위해 아이디를 가져와서 상품을 보여주거나 수정할 수 있게 가져오는 메서드 작성
	public Product getProductById(int id) {
		return productRepository.findProductById(id);
	}
}
