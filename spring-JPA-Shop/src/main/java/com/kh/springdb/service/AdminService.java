package com.kh.springdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.repository.AdminRepository;
import com.kh.springdb.vo.admin;
import com.kh.springdb.vo.customer;
@Service
public class AdminService {
	private final AdminRepository adminRepository;
	
	@Autowired
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	//전체 고객 조회
	public List<admin> getAllCustomers(){
		return adminRepository.findAll();
		
	}
	//고객 하나만 조회
	public Optional<admin> getCustomerById(Long id){
		return adminRepository.findById(id);
	}

}
