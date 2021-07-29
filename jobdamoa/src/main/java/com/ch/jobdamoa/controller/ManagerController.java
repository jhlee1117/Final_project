package com.ch.jobdamoa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.model.Announcement;
import com.ch.jobdamoa.model.Company;
import com.ch.jobdamoa.model.Manager;
import com.ch.jobdamoa.model.Member;
import com.ch.jobdamoa.model.PagingBean;
import com.ch.jobdamoa.service.AnnouncementService;
import com.ch.jobdamoa.service.CompanyService;
import com.ch.jobdamoa.service.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private AnnouncementService announcementService;
	
	@Autowired
	private CompanyService companyService;
	
	//관리자 계정 로그인
	@RequestMapping("managerLogin")
	public String managerLogin(HttpServletRequest request, Model model, HttpSession session) {
		String manager_id = request.getParameter("mem_id");
		String manager_password = request.getParameter("mem_password");
		
		int result = 0; // 암호가 다른 경우
		
		Manager manager = managerService.login(manager_id);
		
		if(manager == null)
			result = -1; // 없는 ID
		else if (manager.getManager_password().equals(manager_password)) {
			result = 1; // ID와 패스워드 일치
			session.setAttribute("manager_num", manager.getManager_num());
			session.setAttribute("manager_id", manager.getManager_id());
			session.setAttribute("user_dist", manager.getUser_dist());
		}
		model.addAttribute("result", result);
		
		return "login/managerLogin";		
	}
	
	//관리자 계정 로그아웃
	@RequestMapping("managerLogout")
	public String memberLogout(HttpServletRequest request, HttpSession session) {
		String referer = request.getHeader("referer");
		session.invalidate();
		return "redirect: " + referer;
	}
	
	//일반 회원 관리 페이지
	@RequestMapping("memberManageForm")
	public String memberManageForm(HttpServletRequest request, Model model, HttpSession session) {
	    if (session == null || session.getAttribute("manager_num") == null) {
	    	return "/sessionChk";
	    }
	    
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
	
	// 일반회원 탈퇴 처리
	@RequestMapping("memberOut")
	public String memberOut(HttpServletRequest request) {
		int result = 0;	
		if(request.getParameterValues("chk_member_id") == null) {
			request.setAttribute("result", result);
			return "manager/memberOut";
		}
		
		String[] member_id = request.getParameterValues("chk_member_id");

		for(String m : member_id) {
			if (managerService.chkMember(m).equals("n")) {
				managerService.delete(m);
				result += 1;
			}
		}
		request.setAttribute("result", result);
		return "manager/memberOut";
	}
	
	// 일반 회원 복구 처리
	@RequestMapping("memberRestore")
	public String memberRestore(HttpServletRequest request) {
		int result = 0;	
		if(request.getParameterValues("chk_member_id") == null) {
			request.setAttribute("result", result);
			return "manager/memberRestore";
		}
		
		String[] member_id = request.getParameterValues("chk_member_id");

		for(String m : member_id) {
			if (managerService.chkMember(m).equals("y")) {
				managerService.restore(m);
				result += 1;
			}
		}
		request.setAttribute("result", result);
		return "manager/memberRestore";
	}
	
	//기업 회원 관리 페이지
	@RequestMapping("companyManageForm")
	public String companyManageForm(HttpServletRequest request, Manager man, Model model, HttpSession session) {
	    if (session == null || session.getAttribute("manager_num") == null) {
	    	return "/sessionChk";
	    }
	    
		final int ROW_PER_PAGE = 10;
		final int PAGE_PER_BLOCK = 10;
		
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = managerService.getCompanyTotal();
		
		// 페이징 시작
		int startRow = (currentPage - 1) * ROW_PER_PAGE + 1;
		int endRow = startRow + ROW_PER_PAGE - 1;
		int number = total - startRow + 1;
		int totalPage = (int) Math.ceil((double) total / ROW_PER_PAGE);
		int startPage = currentPage - (currentPage - 1) % PAGE_PER_BLOCK;
		int endPage = startPage + PAGE_PER_BLOCK - 1;
		if (endPage > totalPage)
			endPage = totalPage;
		
		List<Company> companyList = managerService.companyList(startRow, endRow);
		
		model.addAttribute("companyList", companyList);
		model.addAttribute("PAGE_PER_BLOCK", PAGE_PER_BLOCK);
		model.addAttribute("number", number);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		return "manager/companyManageForm";
	}
	
	// 기업회원 탈퇴 처리
	@RequestMapping("companyOut")
	public String companyOut(HttpServletRequest request) {
		int result = 0;	
		if(request.getParameterValues("chk_company_id") == null) {
			request.setAttribute("result", result);
			return "manager/companyOut";
		}
		
		String[] company_id = request.getParameterValues("chk_company_id");

		for(String c : company_id) {
			if (managerService.chkCompany(c).equals("n")) {
				managerService.companyDelete(c);
				result += 1;
			}
		}
		request.setAttribute("result", result);
		return "manager/memberOut";
	}
		
	// 기업 회원 복구 처리
	@RequestMapping("companyRestore")
	public String companyRestore(HttpServletRequest request) {
		int result = 0;	
		if(request.getParameterValues("chk_member_id") == null) {
			request.setAttribute("result", result);
			return "manager/companyRestore";
		}
		
		String[] member_id = request.getParameterValues("chk_member_id");

		for(String m : member_id) {
			if (managerService.chkMember(m).equals("y")) {
				managerService.restore(m);
				result += 1;
			}
		}
		request.setAttribute("result", result);
		return "manager/companyRestore";
	}
	
	/*채용공고 관리*/
	@RequestMapping("manageAnnouncement")
	public String manageAnnouncement(HttpServletRequest request, HttpSession session, Model model, Announcement ann, String pageNum) {
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";	// 페이지 번호 여부 확인 및 값 초기화
		int currentPage = Integer.parseInt(pageNum); // 숫자로 변환하여 처리
		int rowPerPage = 10; // 한 화면에 보여지는 게시글 개수
		int startRow = (currentPage - 1) * rowPerPage + 1; // 페이지 내 시작행 설정
		int endRow = startRow + rowPerPage - 1; // 페이지 내 끝행 설정
		
		// 전체 페이징 처리
		int total = announcementService.getTotal();
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		
		ann.setStartRow(startRow);
		ann.setEndRow(endRow);
		List<Announcement> annlist = announcementService.annList(ann);
		
		// 회사번호로 회사명을 하나씩 조회해서 annList에 추가해준다.
		for (Announcement ann_com_name : annlist) {
			Company company = companyService.selectCom_nm(ann_com_name.getCom_num());
			if (company != null) { // 게시물과 회사 정보는 동시에 있어야 그렇지 않은 경우 에러 발생 때문에 넣어놓음
				ann_com_name.setCom_name(company.getCom_name());
			} else
				break;
		}
		
		int ann_num = total - startRow + 1;
		model.addAttribute("ann_num", ann_num);
		model.addAttribute("pb", pb);
		model.addAttribute("annlist", annlist);

		
		return "manager/manageAnnouncement";
	}
}
