package com.kh.springdb.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.springdb.vo.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
	

/*
 Repository
 Spring Data JPA에서 제공하는 인터페이스
 	데이터베이스에서 User 엔터티에 접근하는데 사용
 	기본적인 CRUD 작업을 수행할 수  있는 메서드를 제공
 	
 	예를 들어
 		조회 : 전체조회(findAll) 	아이디 하나만 조회(findById)
 		저장 : save
 		삭제 : deleteById
 * */
