package com.ch.jobdamoa.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.jobdamoa.model.Favorites;
import com.ch.jobdamoa.service.AnnouncementService;
import com.ch.jobdamoa.service.FavoritesService;

@Controller
public class FavoritesController {

	@Autowired
	private FavoritesService fs;
	
	@Autowired
	private AnnouncementService as;
	
	
//	@RequestMapping("confirmFav")
//	public String confirmFav(int ann_num, String pageNum, Model model, HttpSession session) {
//		
//	}
	
	@RequestMapping("favSave")
	public String favSave(int ann_num, String pageNum, Model model, HttpSession session) {
		
		System.out.println("게시물 번호: " + ann_num);
		int mem_num = (int) session.getAttribute("mem_num");
		System.out.println("회원일련번호: " + mem_num);
		List<Favorites> favList = fs.confirmFav(mem_num); // 이미 즐겨찾기 추가한 공고인지 확인

		int result;
		
		Favorites fav2 = new Favorites();
		
		if (favList == null) {
			System.out.println("6");
			int number = fs.getMaxNum();
			System.out.println(number);
			fav2.setFav_num(number); // 일련번호 추가
			fav2.setMem_num(mem_num);
			fav2.setAnn_num(ann_num);
//			System.out.println("즐겨찾기 번호 : " + fav.getFav_num());
//			System.out.println("회원 번호 : " + fav.getMem_num());
//			System.out.println("게시물 번호 : " + fav.getAnn_num());
			result = fs.favSave(fav2);
			System.out.println("3");
			System.out.println(result);
		} else if (fav.getAnn_num() == ann_num) {
			result = 0;
			System.out.println("4");
//			System.out.println(fav.getAnn_num());
		} else {
			result = -1;
			System.out.println("5");
		}
		System.out.println("1"
				+ "2");
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("result", result);
		System.out.println("result=" + result);
		return "favorites/favSave";
	}
}
