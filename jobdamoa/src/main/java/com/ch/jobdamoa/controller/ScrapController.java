package com.ch.jobdamoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
