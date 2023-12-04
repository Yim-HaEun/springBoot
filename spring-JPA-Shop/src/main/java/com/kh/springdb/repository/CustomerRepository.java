package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.vo.customer;

public interface CustomerRepository extends JpaRepository<customer,Long>{

	customer findById(String customer_id);
}
