package com.ch.jobdamoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.model.Announcement;
import com.ch.jobdamoa.service.AnnouncementService;
import com.ch.jobdamoa.service.PagingBean;

@Controller
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService as;
	
	@RequestMapping("annList")
	public String annList(Announcement ann, String pageNum, Model model) {
		
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";	// 페이지 번호 여부 확인 및 값 초기화
		int currentPage = Integer.parseInt(pageNum); // 숫자로 변환하여 처리
		int rowPerPage = 10; // 한 화면에 보여지는 게시글 개수
		int startRow = (currentPage - 1) * rowPerPage + 1; // 페이지 내 시작행 설정
		int endRow = startRow + rowPerPage - 1; // 페이지 내 끝행 설정
		
		// 전체 페이징 처리
		int total = as.getTotal();
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		
		ann.setStartRow(startRow);
		ann.setEndRow(endRow);
		List<Announcement> annlist = as.annList(ann);
		
		int ann_num = total - startRow + 1;
		model.addAttribute("ann_num", ann_num);
		model.addAttribute("pb", pb);
		model.addAttribute("annlist", annlist);
		
		return "announcement/annList";
	}
}
