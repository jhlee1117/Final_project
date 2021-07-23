package com.ch.jobdamoa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.jobdamoa.model.Scrap;
import com.ch.jobdamoa.model.ScrapJson;
import com.ch.jobdamoa.service.ScrapService;

@Controller
public class ScrapController {

	@Autowired
	private ScrapService ss;

	@RequestMapping("scrapProgrammers") // 프로그래머스 사이트와 연결
	public String scrapProgrammers(Model model) {
		
		List<ScrapJson> prList = ss.scrapProgrammers();
		model.addAttribute("prList", prList);
		
		return "scrap/scrap_programmers";
	}
	
	@RequestMapping(value = "scrapSave", produces = "text/html;charset=utf-8") // 스크래핑 내용 즐겨찾기 추가
	@ResponseBody
	public String scrapSave(ScrapJson sc, HttpSession session) {
		
		String msg = "";
		int mem_num = (int) session.getAttribute("mem_num");
		
		Scrap scchk = new Scrap();
		scchk.setMem_num(mem_num);
		scchk.setScrap_title(sc.getTitle());
		
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
			int result = ss.scrapSave(scrap2);
			msg = "공고 저장에 성공했습니다.";
		} else if (scrap.getScrap_title() != null) {
			msg = "이미 저장한 공고입니다.";
		} else {
			msg = "공고 저장에 실패했습니다.";
		}
		
		return msg;
	}
}
