package com.kh.springdb.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springdb.repository.StmemberRepository;
import com.kh.springdb.vo.STMEMBER;
@Service
public class StmemberService {

	//전체조회, 값 입력, 수정, 삭제
	@Autowired
	private final StmemberRepository stRepository;
	
	//생성자
	public StmemberService(StmemberRepository stRepository) {
		this.stRepository = stRepository;
	}
	//전체조회, 값 입력, 수정, 삭제
	//1.전체조회
	public List<STMEMBER> getAllMember(){
		return stRepository.findAll();
	}
	//2.값 입력해서 저장하는 메서드
	@Transactional
	public STMEMBER saveMember(STMEMBER stmember) {
		return stRepository.save(stmember);
	}
	//3.삭제하는 메서드
	public void deleteMemberById(Long id) {
		stRepository.deleteById(id);
	}
	//4.아이디 한개 조회 메서드
	public Optional<STMEMBER> getMemberById(Long id) {
	
		return stRepository.findById(id);
	}
}
