package com.ch.jobdamoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {
	
	@RequestMapping("selectJoinForm")
	public String selectJoinForm() {
		return "join/selectJoinForm";
	}

}
