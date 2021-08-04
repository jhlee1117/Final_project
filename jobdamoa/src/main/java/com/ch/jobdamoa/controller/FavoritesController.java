package com.ch.jobdamoa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.jobdamoa.model.Favorites;
import com.ch.jobdamoa.model.PagingBean;
import com.ch.jobdamoa.service.FavoritesService;

@Controller
public class FavoritesController {

	@Autowired
	private FavoritesService fs;

	@RequestMapping("favSave")
	public String favSave(int ann_num, String pageNum, Model model, HttpSession session) {
		
		int mem_num = (int) session.getAttribute("mem_num");
		
		Favorites favchk = new Favorites();
		
		favchk.setAnn_num(ann_num);
		favchk.setMem_num(mem_num);
		
		Favorites fav = fs.confirmFav(favchk); // 이미 즐겨찾기 추가한 공고인지 확인
		
		int result;
		if (fav == null) {
			int number = fs.getMaxNum();
			Favorites fav2 = new Favorites();
			fav2.setFav_num(number); // 일련번호 추가
			fav2.setMem_num(mem_num);
			fav2.setAnn_num(ann_num);
			result = fs.favSave(fav2);
		} else if (fav.getAnn_num() == ann_num) {
			result = 0;
		} else {
			result = -1;
		}

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("result", result);

		return "favorites/favSave";
	}
	
	@RequestMapping("myFavList")
	public String favAnnList(Favorites fav, HttpSession session, String pageNum, Model model) {
		
		int mem_num = (int) session.getAttribute("mem_num");
		
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";	// 페이지 번호 여부 확인 및 값 초기화
		int currentPage = Integer.parseInt(pageNum); // 숫자로 변환하여 처리
		int rowPerPage = 10; // 한 화면에 보여지는 게시글 개수
		int startRow = (currentPage - 1) * rowPerPage + 1; // 페이지 내 시작행 설정
		int endRow = startRow + rowPerPage - 1; // 페이지 내 끝행 설정
		
		// 내가 저장한 공고만 페이징 처리
		int total = fs.getMyTotal(mem_num);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
				
		fav.setStartRow(startRow);
		fav.setEndRow(endRow);
		fav.setMem_num(mem_num);
		
//		List<Favorites> myfavlist = fs.favList(mem_num);
		List<Favorites> myfavlist = fs.favList(fav);
		
		model.addAttribute("pb", pb);
		model.addAttribute("myfavlist", myfavlist);
				
		return "favorites/myFavList";
	}
	
	@RequestMapping(value = "favDelete", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String favDelete(int ann_num, int pageNum) {
		
		List<Favorites> cflist = fs.confirmFavAnn(ann_num);

		String msg;
		
		if (cflist.isEmpty()) {
			msg = "정상적으로 삭제하였습니다.";
			fs.favDelete(ann_num);
		} else {
			msg = "중지된 공고는 삭제할 수 없습니다.";
		}
		return msg;
	}
}
