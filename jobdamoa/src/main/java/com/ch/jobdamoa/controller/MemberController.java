package com.ch.jobdamoa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.model.Member;
import com.ch.jobdamoa.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService ms;
	
	@RequestMapping("memberLoginForm")
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
	
	@RequestMapping("memberLogin")
	public String memberLogin(Member mem, Model model, HttpSession session) {
		
		int result = 0; // 암호가 다른 경우
		
		Member mem2 = ms.selectLogin(mem.getMem_id());
		
		if(mem2 == null || mem2.getMem_invalid().equals("y"))
			result = -1;
		else if (mem2.getMem_password().equals(mem.getMem_password())) {
			result = 1; // ID와 패스워드 일치
			session.setAttribute("mem_id", mem.getMem_id());
			session.setAttribute("user_dist", mem.getUser_dist());
		}
		model.addAttribute("result", result);
		return "member/memberLogin";		
	}
	
}
