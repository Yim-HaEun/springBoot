package com.kh.cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.cafe.repository.CafeRepository;
import com.kh.cafe.vo.Cafe;

@Service
public class CafeService {
	private final CafeRepository cafeRepository;
	
	@Autowired
	public CafeService(CafeRepository cafeRepository) {
		this.cafeRepository = cafeRepository;
	}
	//모든 카페 조회
	public List<Cafe> getAllCafes(){
		return cafeRepository.findAll();
	}
	//상세 조회
	public Optional<Cafe> getCafeById(Long id){
		return cafeRepository.findById(id);
	}
	//카페 추가하기
	public Cafe saveCafe(Cafe cafe) {
		return cafeRepository.save(cafe);
	}
	//카페 삭제하기
	public void deleteCafeById(Long id) {
		cafeRepository.deleteById(id);
	}
	//게시물 모두 삭제
	public void deleteAllCafes() {
		cafeRepository.deleteAll();
	}
	//특정 검색어로 검색하는 메서드
	public List<Cafe> searchCafe(String keyword){
		return cafeRepository.findByNameContaining(keyword);
	}
	//repository에 작성한 지역카운터를 가져와서 이용할 수 있는 메서드를 추가
	public int countCafesByLocation(String location) {
		return cafeRepository.countByLocation(location);
	}
	//카페가 존재하는지 존재 여부
	public boolean existCafeByName(String name) {
		return cafeRepository.existByName(name);
	}
}
