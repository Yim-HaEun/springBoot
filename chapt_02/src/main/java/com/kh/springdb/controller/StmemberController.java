package com.kh.springdb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.sevice.StmemberService;
import com.kh.springdb.vo.STMEMBER;

@Controller
@RequestMapping("/members")
public class StmemberController {
	@Autowired
	private StmemberService stService;
	
	public StmemberController(StmemberService stService)  {
		this.stService = stService;
	}
	@GetMapping
	public String getAllMember(Model model) {
		model.addAttribute("members",stService.getAllMember());
		return "memberList";
	}
	//insert
	@GetMapping("/new")
	public String showMemberForm(Model model) {
		model.addAttribute("member",new STMEMBER());
		return "memberForm";
	}
	@PostMapping("/save")
	public String saveMember(@ModelAttribute STMEMBER stMember) {
		stService.saveMember(stMember);//멤버 모두 저장
		return "redirect:/members";
	}
	
	//update
	@GetMapping("/update/{memberId}")
	public String updateMember(@PathVariable Long id,Model model) {
		//옵셔널 이용해서 아이디값 가져오기
		Optional <STMEMBER> stmember = stService.getMemberById(id);
		
		//람다식 사용해서 member에 값을 추가하느 코드 작성
		stmember.ifPresent(value -> model.addAttribute("stmember",value));
		return "memberForm";
	}
	
	//delete
	@GetMapping("/delete/{id}")
	public String deleteMember(@PathVariable Long id) {
		stService.deleteMemberById(id);
		return "redirect:/members";
	}

}
