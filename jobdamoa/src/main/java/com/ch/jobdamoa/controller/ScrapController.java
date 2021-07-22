package com.ch.jobdamoa.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.model.Programmers;
import com.ch.jobdamoa.service.ScrapService;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

@Controller
public class ScrapController {

	@Autowired
	private ScrapService ss;

	@RequestMapping("scrapProgrammers") // 프로그래머스 사이트와 연결
	public String scrapProgrammers(Model model) {
		
		List<Programmers> prList = null;
		
		// JSON 데이터를 읽어와서 객체로 변환 후 해당 사이트로 보내줌
		try {
			// Json 파일을 읽어들임 (경로 지정 필수)
			Reader reader = new FileReader(
					"C:\\my_project\\spring\\final_project\\jobdamoa\\src\\main\\webapp\\python_scrap\\data.json");
			
			// 구글에서 제공하는 Gson으로 Json 데이터를 파싱
			Gson gson = new Gson();
			
			// JsonReader는 불러들인 JSON 파일 형식의 오류나 문제를 잡아주는 역할을 함
			JsonReader jreader = new JsonReader(reader);
			jreader.setLenient(true);
			
			// Type을 써서 배열로 구성된 Json을 Programmers 객체가 담긴 리스트로 변환 
			Type prListType = new TypeToken<ArrayList<Programmers>>() {
			}.getType();
			prList = gson.fromJson(jreader, prListType);

			for (int i = 0; i < prList.size(); i++) {
				System.out.println(prList.get(i));
				System.out.println(prList.get(i).getCompany());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		model.addAttribute("prList", prList);
		
		return "scrap/scrap_programmers";
	}
}
