package com.ch.jobdamoa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.jobdamoa.model.Company;
import com.ch.jobdamoa.model.Member;
import com.ch.jobdamoa.service.CompanyService;
import com.ch.jobdamoa.service.MemberService;

@Controller
public class JoinController {

	@Autowired
	private CompanyService cs;
	
	@Autowired
	private MemberService ms;	
	
	@RequestMapping("selectJoinForm")
	public String selectJoinForm() {
		return "join/selectJoinForm";
	}
	
	@RequestMapping("companyJoinForm")
	public String companyJoinForm() {
		return "join/companyJoinForm";
	}
	
	@RequestMapping(value = "confirmCom", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String confirmCom(HttpServletRequest request) {
		
		String com_id = request.getParameter("com_id");
		String msg = "";
		Company com = cs.selectLogin(com_id);
		
		if (com == null)
			msg = "사용 가능한 아이디입니다.";
		else
			msg = "사용 중이니 다른 아이디를 사용하세요.";
		
		return msg;
	}
	
	@RequestMapping("memberJoinForm")
	public String memberJoinForm() {
		return "join/memberJoinForm";
	}
	
	@RequestMapping(value = "confirmMem", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String confirmMem(HttpServletRequest request) {
		
		String mem_id = request.getParameter("mem_id");
		String msg = "";
		Member mem = ms.selectLogin(mem_id);
		
		if (mem == null)
			msg = "사용 가능한 아이디입니다.";
		else
			msg = "사용 중이니 다른 아이디를 사용하세요.";
		
		return msg;
	}
}
