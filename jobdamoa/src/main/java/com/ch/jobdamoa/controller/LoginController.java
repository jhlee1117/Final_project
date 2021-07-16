package com.ch.jobdamoa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.model.Company;
import com.ch.jobdamoa.model.Member;
import com.ch.jobdamoa.service.CompanyService;
import com.ch.jobdamoa.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	private CompanyService cs;

	@Autowired
	private MemberService ms;
		
	@RequestMapping("selectLoginForm")
	public String selectJoinForm() {
		return "login/selectLoginForm";
	}
	
	@RequestMapping("companyLoginForm")
	public String companyLoginForm() {
		return "login/companyLoginForm";
	}
	
	@RequestMapping("companyLogin")
	public String companyLogin(Company com, Model model, HttpSession session) {
		
		int result = 0; // 암호가 다른 경우
		
		Company com2 = cs.selectLogin(com.getCom_id());

		if(com2 == null || com2.getCom_invalid().equals("y"))
			result = -1; // 없는 ID
		else if (com2.getCom_password().equals(com.getCom_password())) {
			result = 1; // ID와 패스워드가 일치
			session.setAttribute("com_num", com2.getCom_num());
			session.setAttribute("com_name", com2.getCom_name());
			session.setAttribute("user_dist", com2.getUser_dist());
		}
		model.addAttribute("result", result);
		return "login/companyLogin";
	}
	
	@RequestMapping("companyLogout")
	public String companyLogout(HttpSession session) {
		session.invalidate();
		return "home/home";
	}
	@RequestMapping("memberLoginForm")
	public String memberLoginForm() {
		return "login/memberLoginForm";
	}
	
	@RequestMapping("memberLogin")
	public String memberLogin(Member mem, Model model, HttpSession session) {
		
		int result = 0; // 암호가 다른 경우
		
		Member mem2 = ms.selectLogin(mem.getMem_id());
		
		if(mem2 == null || mem2.getMem_invalid().equals("y"))
			result = -1; // 없는 ID
		else if (mem2.getMem_password().equals(mem.getMem_password())) {
			result = 1; // ID와 패스워드 일치
			session.setAttribute("mem_num", mem2.getMem_num());
			session.setAttribute("mem_nickname", mem2.getMem_nickname());
			session.setAttribute("user_dist", mem2.getUser_dist());
		}
		model.addAttribute("result", result);
		return "login/memberLogin";		
	}
	
	@RequestMapping("memberLogout")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		return "home/home";
	}
}
