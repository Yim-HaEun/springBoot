package com.kh.pre;

import org.springframework.web.bind.annotation.RequestMapping;

public class IntroController {
	@RequestMapping("/intro")
	public String getIntro() {
		return "Intro";
	}
}
