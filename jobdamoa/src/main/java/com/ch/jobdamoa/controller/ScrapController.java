package com.ch.jobdamoa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.jobdamoa.model.Favorites;
import com.ch.jobdamoa.model.PagingBean;
import com.ch.jobdamoa.model.Scrap;
import com.ch.jobdamoa.model.ScrapJson;
import com.ch.jobdamoa.service.ScrapService;

@Controller
public class ScrapController {

	@Autowired
	private ScrapService ss;

	@RequestMapping("scrapProgrammers") // 프로그래머스 사이트와 연결
	public String scrapProgrammers(String pageNum, Model model) {

		List<ScrapJson> prAllList = ss.scrapProgrammers();

		if (pageNum == null || pageNum.equals(""))
			pageNum = "1"; // 페이지 번호 여부 확인 및 값 초기화
		int currentPage = Integer.parseInt(pageNum); // 숫자로 변환하여 처리
		int rowPerPage = 10; // 한 화면에 보여지는 게시글 개수
		int startRow = (currentPage - 1) * rowPerPage; // 페이지 내 시작행 설정
		int endRow = startRow + rowPerPage - 1; // 페이지 내 끝행 설정

		// 전체 페이징 처리
		int total = prAllList.size();
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);

		List<ScrapJson> prList = new ArrayList<>();

		if (currentPage == total / rowPerPage + 1) {
			for (int i = 0; i < total % rowPerPage; i++) {
				prList.add(i, prAllList.get(startRow));
				startRow++;
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				prList.add(i, prAllList.get(startRow));
				startRow++;
			}
		}

		model.addAttribute("prList", prList);
		model.addAttribute("pb", pb);

		return "scrap/scrap_programmers";
	}

	@RequestMapping("scrapSaramin") // 사람인 사이트와 연결
	public String scrapSaramin(String pageNum, Model model) {

		List<ScrapJson> saramAllList = ss.scrapSaramin();

		if (pageNum == null || pageNum.equals(""))
			pageNum = "1"; // 페이지 번호 여부 확인 및 값 초기화
		int currentPage = Integer.parseInt(pageNum); // 숫자로 변환하여 처리
		int rowPerPage = 10; // 한 화면에 보여지는 게시글 개수
		int startRow = (currentPage - 1) * rowPerPage; // 페이지 내 시작행 설정
		int endRow = startRow + rowPerPage - 1; // 페이지 내 끝행 설정

		// 전체 페이징 처리
		int total = saramAllList.size();
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		List<ScrapJson> saramList = new ArrayList<>();

		if (currentPage == total / rowPerPage + 1) {
			for (int i = 0; i < total % rowPerPage; i++) {
				saramList.add(i, saramAllList.get(startRow));
				startRow++;
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				saramList.add(i, saramAllList.get(startRow));
				startRow++;
			}
		}

		model.addAttribute("saramList", saramList);
		model.addAttribute("pb", pb);

		return "scrap/scrap_saramin";
	}	
	
	@RequestMapping(value = "scrapSave", produces = "text/html;charset=utf-8") // 스크래핑 내용 즐겨찾기 추가
	@ResponseBody
	public String scrapSave(ScrapJson sc, HttpSession session, String scrap_from) {
		
		if (sc.getLink().indexOf("And") > 0) {
			sc.setLink(sc.getLink().replace("And", "&")); // And를 &로 변경해서 링크 주소를 넣어줌
		}
		
		String msg = "";
		int mem_num = (int) session.getAttribute("mem_num");

		Scrap scchk = new Scrap();
		scchk.setMem_num(mem_num);
		scchk.setScrap_title(sc.getTitle());
		scchk.setScrap_company(sc.getCompany());

		Scrap scrap = ss.confirmScrap(scchk); // 이미 즐겨찾기 추가한 공고인지 확인

		if (scrap == null) {
			int number = ss.getMaxNum();
			Scrap scrap2 = new Scrap();
			scrap2.setScrap_num(number); // 일련번호 추가
			scrap2.setMem_num(mem_num);
			scrap2.setScrap_title(sc.getTitle());
			scrap2.setScrap_company(sc.getCompany());
			scrap2.setScrap_location(sc.getLocation());
			scrap2.setScrap_career(sc.getExperience()); // 받아오는 데이터는 experience, 즐겨찾기에서는 scrap_career
			scrap2.setScrap_link(sc.getLink());
			scrap2.setScrap_from(scrap_from);
			int result = ss.scrapSave(scrap2);
			msg = "공고 저장에 성공했습니다.";
		} else if (scrap.getScrap_title() != null) {
			msg = "이미 저장한 공고입니다.";
		} else {
			msg = "공고 저장에 실패했습니다.";
		}

		return msg;
	}
	
	@RequestMapping("myScrapList")
	public String myScrapList(Scrap scrap, HttpSession session, String pageNum, Model model) {
		
		int mem_num = (int) session.getAttribute("mem_num");
		
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";	// 페이지 번호 여부 확인 및 값 초기화
		int currentPage = Integer.parseInt(pageNum); // 숫자로 변환하여 처리
		int rowPerPage = 10; // 한 화면에 보여지는 게시글 개수
		int startRow = (currentPage - 1) * rowPerPage + 1; // 페이지 내 시작행 설정
		int endRow = startRow + rowPerPage - 1; // 페이지 내 끝행 설정
		
		// 내가 저장한 공고만 페이징 처리
		int total = ss.getMyTotal(mem_num);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		
		scrap.setStartRow(startRow);
		scrap.setEndRow(endRow);
		scrap.setMem_num(mem_num);
		
		List<Scrap> myscraplist = ss.scrapList(scrap);
		
		model.addAttribute("pb", pb);
		model.addAttribute("myscraplist", myscraplist);
		
		return "scrap/myScrapList";
	}
	
	@RequestMapping(value = "scrapDelete", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String scrapDelete(int scrap_num, int pageNum) {
		int result = 0;
		result = ss.scrapDelete(scrap_num);
		String msg;
		
		if (result > 0) {
			msg = "정상적으로 삭제하였습니다.";
			
		} else {
			msg = "삭제에 실패하였습니다.";
		}
		return msg;
	}
}
