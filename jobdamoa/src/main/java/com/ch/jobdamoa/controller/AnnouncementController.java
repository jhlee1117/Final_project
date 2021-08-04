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
import com.ch.jobdamoa.model.PagingBean;
import com.ch.jobdamoa.service.AnnouncementService;
import com.ch.jobdamoa.service.CompanyService;

@Controller
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService as;
	
	@Autowired
	private CompanyService cs;
	
	@RequestMapping("annList")
	public String annList(Announcement ann, Company com, String pageNum, Model model) {
		
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";	// 페이지 번호 여부 확인 및 값 초기화
		int currentPage = Integer.parseInt(pageNum); // 숫자로 변환하여 처리
		int rowPerPage = 10; // 한 화면에 보여지는 게시글 개수
		int startRow = (currentPage - 1) * rowPerPage + 1; // 페이지 내 시작행 설정
		int endRow = startRow + rowPerPage - 1; // 페이지 내 끝행 설정
		
		// 전체 페이징 처리
		int total = as.getTotal();
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		String[] select = {"공고명","근무지","직무"};
		
		ann.setStartRow(startRow);
		ann.setEndRow(endRow);
		List<Announcement> annlist = as.annList(ann);
		
		// 회사번호로 회사명을 하나씩 조회해서 annList에 추가해준다.
		for (Announcement ann_com_name : annlist) {
			Company company = cs.selectCom_nm(ann_com_name.getCom_num());
			if (company != null) { // 게시물과 회사 정보는 동시에 있어야 그렇지 않은 경우 에러 발생 때문에 넣어놓음
				ann_com_name.setCom_name(company.getCom_name());
			} else
				break;
		}
		
		int ann_num = total - startRow + 1;
		model.addAttribute("select", select);
		model.addAttribute("ann_num", ann_num);
		model.addAttribute("pb", pb);
		model.addAttribute("annlist", annlist);
				
		return "announcement/annList";
	}
	
	@RequestMapping("annInsertForm")
	public String annInsertForm(int ann_num, String pageNum, Model model, HttpSession session) {
		
		int result;
		Integer com_num = (Integer) session.getAttribute("com_num");
		String user_dist = (String) session.getAttribute("user_dist");
		
		if (com_num == null || !user_dist.equals("1")) {
			result = 0;
		} else {
			result = 1;
			model.addAttribute("com_name", (String) session.getAttribute("com_name"));
			model.addAttribute("ann_num", ann_num);
			model.addAttribute("pageNum", pageNum);
		}
		session.setAttribute("result", result);
		
		return "announcement/annInsertForm";
	}
	
	@RequestMapping("annInsert")
	public String annInsert(Announcement ann, String pageNum, Model model, HttpServletRequest request) {
		
		ann.setCom_num(Integer.parseInt(request.getParameter("com_num")));
		
		int number = as.getMaxNum();
		ann.setAnn_num(number); // 일련번호 추가
		
		int result = as.annInsert(ann);
		
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		
		return "announcement/annInsert";
	}
	 
	@RequestMapping("annView")
	public String annView(int ann_num, String pageNum, Model model, HttpSession session) { 
		Announcement ann = as.annView(ann_num);
		// 중지된 공고는 작성한 회사 외에 조회 불가능하도록 접근 제한 페이지 처리
		if (ann.getAnn_del().equals("y") && session.getAttribute("com_num") == null) {
			return "announcement/annFail";
		} else if (ann.getAnn_del().equals("y") && ann.getCom_num() != ((int) session.getAttribute("com_num"))) {
			return "announcement/annFail";
		}
		
		as.updateReadCount(ann_num);
		Company com = cs.selectCom(ann.getCom_num());
		model.addAttribute("ann", ann);
		model.addAttribute("com", com);
		model.addAttribute("pageNum", pageNum);
		return "announcement/annView";
	}
	
	@RequestMapping("myAnnList")
	public String myAnnList(Announcement ann, HttpSession session, String pageNum, Model model) {
		
		int com_num = (int) session.getAttribute("com_num");
//		String com_name = (String) session.getAttribute("com_name");
		
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";	// 페이지 번호 여부 확인 및 값 초기화
		int currentPage = Integer.parseInt(pageNum); // 숫자로 변환하여 처리
		int rowPerPage = 10; // 한 화면에 보여지는 게시글 개수
		int startRow = (currentPage - 1) * rowPerPage + 1; // 페이지 내 시작행 설정
		int endRow = startRow + rowPerPage - 1; // 페이지 내 끝행 설정
		
		// 내가 쓴 글만 페이징 처리
		int total = as.getMyTotal(com_num);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		
		ann.setStartRow(startRow);
		ann.setEndRow(endRow);
		ann.setCom_num(com_num);
		
		List<Announcement> myannlist = as.myAnnList(ann);
		
		model.addAttribute("pb", pb);
		model.addAttribute("myannlist", myannlist);
		
		return "announcement/myAnnList";
	}
	
	@RequestMapping("annUpdateForm")
	public String annUpdateForm(int ann_num, String pageNum, Model model, HttpSession session) {
		
		int result;
		Announcement ann = as.annView(ann_num);
		
		if (ann.getAnn_del().equals("y")) {
			result = 0;
		} else {
			result = 1;
			
			model.addAttribute("ann_num", ann_num);
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("ann", ann);
		}
		session.setAttribute("result", result);
		
		return "announcement/annUpdateForm";
	}
	
	@RequestMapping("annUpdate")
	public String annUpdate(Announcement ann, String pageNum, Model model) {
		
		int result = as.annUpdate(ann);
		model.addAttribute("result", result);
		model.addAttribute("ann_num", ann.getAnn_num()); // View로 보내는 것이므로 받는 값이 ann_num
		model.addAttribute("pageNum", pageNum);
		
		return "announcement/annUpdate";
	}
	
	@RequestMapping("annDeleteForm")
	public String annDeleteForm(int ann_num, String pageNum, Model model, HttpSession session) {
		
		int result = 0;
		String userDist = (String)session.getAttribute("user_dist");
		System.out.println(userDist);
		Announcement ann = as.annView(ann_num);
		
		if (ann.getAnn_del().equals("y")) {
			result = 0;
		} else if (userDist.equals("1")) {
			result = 1;
		} else if (userDist.equals("2")) {
			result = 2;
		}

		model.addAttribute("ann_num", ann_num);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("ann", ann);
		model.addAttribute("result", result);
		
		return "announcement/annDeleteForm";
	}
	
	@RequestMapping("annDelete")
	public String annDelete(int ann_num, String pageNum, Model model) {
		
		int result = as.annDelete(ann_num);
		
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		
		return "announcement/annDelete";
	}
	
	@RequestMapping("annFail")
	public String annFail() {
		return "announcement/annFail";
	}
}
