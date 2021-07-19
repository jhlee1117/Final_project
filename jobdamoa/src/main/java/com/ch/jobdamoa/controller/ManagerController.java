package com.ch.jobdamoa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.model.Manager;
import com.ch.jobdamoa.model.Member;
import com.ch.jobdamoa.service.ManagerService;
import com.ch.jobdamoa.service.MemberService;

@Controller
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("managerLoginForm")
	public String memberLoginForm() {
		return "manager/managerLoginForm";
	}
	
	@RequestMapping("managerLogin")
	public String managerLogin(HttpServletRequest request, Model model, HttpSession session) {
		String referer = request.getParameter("referer");
		String manager_id = request.getParameter("mem_id");
		String manager_password = request.getParameter("mem_password");
		
		int result = 0; // 암호가 다른 경우
		
		Manager manager = managerService.login(manager_id);
		
		if(manager == null)
			result = -1; // 없는 ID
		else if (manager.getManager_password().equals(manager_password)) {
			result = 1; // ID와 패스워드 일치
			session.setAttribute("manager_num", manager.getManager_num());
			session.setAttribute("user_dist", manager.getUser_dist());
		}
		model.addAttribute("result", result);
		model.addAttribute("referer", referer);
		return "manager/managerLogin";		
	}
	
	@RequestMapping("managerLogout")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		return "home/home";
	}
	
	@RequestMapping("memberManageForm")
	public String memberManageForm(HttpServletRequest request, Manager man, Model model, HttpSession session) {
	    /*if (session == null || session.getAttribute("manager_id") == null) {
	    	return "../sessionChk";
	    }*/
	    
		final int ROW_PER_PAGE = 10;
		final int PAGE_PER_BLOCK = 10;
		
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = managerService.getTotal();
		
		// 페이징 시작
		int startRow = (currentPage - 1) * ROW_PER_PAGE + 1;
		int endRow = startRow + ROW_PER_PAGE - 1;
		int number = total - startRow + 1;
		int totalPage = (int) Math.ceil((double) total / ROW_PER_PAGE);
		int startPage = currentPage - (currentPage - 1) % PAGE_PER_BLOCK;
		int endPage = startPage + PAGE_PER_BLOCK - 1;
		if (endPage > totalPage)
			endPage = totalPage;
		
		List<Member> memberList = managerService.memberList(startRow, endRow);
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("PAGE_PER_BLOCK", PAGE_PER_BLOCK);
		model.addAttribute("number", number);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		return "manager/memberManageForm";
	}
}
