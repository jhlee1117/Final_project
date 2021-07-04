package com.ch.jobdamoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	// 메인화면을 보여주는 컨트롤러
	@RequestMapping("home")
	public String home() {
		return "home/home";
	}
}
