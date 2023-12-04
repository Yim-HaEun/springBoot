package com.kh.springdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.vo.dao.MemberDAO;
import com.kh.springdb.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	//전체보기
	
	//멤버에 대한 정보를 상세보기
	
	/*public MemberVO getMemberById(int memberId) {
		return memberdao.getById(memberId)
	}*/
	//삽입하기
	public void insertMember(MemberVO member) {
		memberDAO.insertMember(member);
	}
	//수정하기
	
	//삭제하기

}
