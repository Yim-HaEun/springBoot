package com.kh.springdb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.repository.CustomerRepository;
import com.kh.springdb.vo.customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	//1.회원가입 메서드
	public customer saveCustomer(customer customer) {
		
		return customerRepository.save(customer);
	}
	//이미 가입한 회원인지 아닌지 체크해주는 메서드
	public void validateDuplicateCustomer(customer customer) {
		customer findCustomer = customerRepository.findById(customer.getCustomer_id());
		
		if(findCustomer != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
	

}
