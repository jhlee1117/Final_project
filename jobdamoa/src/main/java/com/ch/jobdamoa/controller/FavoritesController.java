package com.ch.jobdamoa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.model.Favorites;
import com.ch.jobdamoa.service.FavoritesService;

@Controller
public class FavoritesController {

	@Autowired
	private FavoritesService fs;

	@RequestMapping("favSave")
	public String favSave(int ann_num, String pageNum, Model model, HttpSession session) {
		
		System.out.println("게시물 번호: " + ann_num);
		int mem_num = (int) session.getAttribute("mem_num");
		System.out.println("회원일련번호: " + mem_num);
		
		Favorites favchk = new Favorites();
		
		favchk.setAnn_num(ann_num);
		favchk.setMem_num(mem_num);
		
		Favorites fav = fs.confirmFav(favchk); // 이미 즐겨찾기 추가한 공고인지 확인
		
		int result;
		if (fav == null) {
			System.out.println("null 진입점");
			int number = fs.getMaxNum();
			System.out.println("일련번호: " + number);
			Favorites fav2 = new Favorites();
			System.out.println("객체 생성 후");
			fav2.setFav_num(number); // 일련번호 추가
			fav2.setMem_num(mem_num);
			fav2.setAnn_num(ann_num);
			result = fs.favSave(fav2);
			System.out.println("객체값 확인 " + result);
		} else if (fav.getAnn_num() == ann_num) {
			result = 0;
			System.out.println("0");
		} else {
			result = -1;
			System.out.println("-1");
		}
		System.out.println("성공");
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("result", result);
		System.out.println("result=" + result);
		return "favorites/favSave";
	}
}
