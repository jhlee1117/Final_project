package com.ch.jobdamoa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.model.Company;
import com.ch.jobdamoa.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService cs;
	
	@RequestMapping("companyLoginForm")
	public String companyLoginForm() {
		return "company/companyLoginForm";
	}
	
	@RequestMapping("companyLogin")
	public String companyLogin(Company com, Model model, HttpSession session) {
		
		int result = 0; // 암호가 다른 경우
		
		Company com2 = cs.selectLogin(com.getCom_id());

		if(com2 == null || com2.getCom_invalid().equals("y"))
			result = -1; // 없는 ID
		else if (com2.getCom_password().equals(com.getCom_password())) {
			result = 1; // ID와 패스워드가 일치
			session.setAttribute("com_id", com.getCom_id());
			session.setAttribute("user_dist", com.getUser_dist());
		}
		model.addAttribute("result", result);
		return "company/companyLogin";
	}
}
