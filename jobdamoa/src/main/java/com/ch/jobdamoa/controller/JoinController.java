package com.ch.jobdamoa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {
	
	@RequestMapping("selectJoinForm")
	public String selectJoinForm(HttpServletRequest request, HttpSession session) {
		String previouspage = request.getHeader("referer");
		previouspage = previouspage.replace("memberJoin.do", "home.do");
		previouspage = previouspage.replace("companyJoin.do", "home.do");
		session.setAttribute("previouspage", previouspage);
		
		return "join/selectJoinForm";
	}

}
