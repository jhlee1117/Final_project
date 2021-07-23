package com.ch.jobdamoa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.model.ScrapJson;
import com.ch.jobdamoa.service.ScrapService;

@Controller
public class HomeController {

	@Autowired
	private ScrapService ss;

	// 메인화면을 보여주는 컨트롤러
	@RequestMapping("home")
	public String home(Model model) {

		List<ScrapJson> prList = ss.scrapProgrammers(); // 우선 데이터를 긁어옴
		// 최근 5가지만 우선 저장하여 보내줌
		List<ScrapJson> prRecentList = new ArrayList<>(); 
		for (int i = 0; i < prList.size(); i++) {
			if (i >= 5)
				break;
			prRecentList.add(prList.get(i));
		}

		model.addAttribute("prRecentList", prRecentList);

		return "home/home";
	}
}
