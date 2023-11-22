package com.kh.springprojectchap1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

public class NewFileController {
	//html jsp view 공간과 db 연결하는 역할
	//파일 경로를 설정할 때 항상 run하는 java파일 하위 폴더에다가 설정
	//만약에 하위로 두지않고 따로 만들어서 사용할 경우에는 폴더를 바라보는 위치를 (컴포넌트 스캔을) 별도로 지정해줘야함
	@SpringBootApplication
	public String hello() {
		return "Hello,world";
	}

}
