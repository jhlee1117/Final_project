package com.ch.jobdamoa.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.service.ScrapService;

@Controller
public class ScrapController {

	@Autowired
	private ScrapService ss;
	
	@RequestMapping("scrapProgrammers") // 프로그래머스 사이트와 연결
	public String scrapProgrammers() {
//		
//		String path = System.getProperty("user.dir") + "\\python_scrap"; // 파이썬 경로
//		File file = new File(path + "save.py"); // 파이썬 파일명
//		
//		try {
//			Process p = Runtime.getRuntime().exec("python " + file);
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//		if (p)
		return "scrap/scrap_programmers";
	}
}
