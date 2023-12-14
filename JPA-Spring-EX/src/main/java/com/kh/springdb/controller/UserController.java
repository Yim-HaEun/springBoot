package com.kh.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import com.kh.springdb.model.UserCreateForm;
import com.kh.springdb.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("user")
//공통으로들어가는 url이 있다면 RequestMapping 사용해서 user로 묶어주기
public class UserController {
	private final UserService userService;
	
	//회원가입 창
	@GetMapping("/signup")
	public String signUp(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	//회원가입에대한 postMapping
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		//만약 패스워드 두개가 일치하지 않는다면 일치하지않습니다
		if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect","비밀번호와 비밀번호 확인이 일치하지않습니다.");
			return "signup_form";
		}
		userService.createUser(userCreateForm.getUsername(), userCreateForm.getPassword1(),userCreateForm.getEmail(),userCreateForm.getIsRole());
		return "redirect:/";
	}
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
	

}
