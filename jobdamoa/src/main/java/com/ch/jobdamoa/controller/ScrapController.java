package com.ch.jobdamoa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.jobdamoa.model.PagingBean;
import com.ch.jobdamoa.model.Scrap;
import com.ch.jobdamoa.model.ScrapJson;
import com.ch.jobdamoa.service.ScrapService;

@Controller
public class ScrapController {

	@Autowired
	private ScrapService ss;

	@RequestMapping("scrapProgrammers") // 프로그래머스 사이트와 연결
	public String scrapProgrammers(String pageNum, Model model, String search, String keyword) {

		String fileName = "scrap_result_programmers.json";

		String prDate = ss.getDate(fileName);
		List<ScrapJson> prAllList = ss.scrapProgrammers(fileName);

		if (pageNum == null || pageNum.equals(""))
			pageNum = "1"; // 페이지 번호 여부 확인 및 값 초기화
		int currentPage = Integer.parseInt(pageNum); // 숫자로 변환하여 처리
		int rowPerPage = 10; // 한 화면에 보여지는 게시글 개수
		int startRow = (currentPage - 1) * rowPerPage; // 페이지 내 시작행 설정
		int endRow = startRow + rowPerPage - 1; // 페이지 내 끝행 설정

		// 전체 페이징 처리
		int total = prAllList.size();

		List<ScrapJson> prList = new ArrayList<>();
		String[] select = { "공고명", "회사명", "근무지", "직무" }; // 검색 기능 필터 내용 부분

		// 초기 검색이 되지 않을 때 prAllList에서 모든 행을 가져옴
		if (search == null) {
			if (currentPage == total / rowPerPage + 1) { // 9페이지 이하 나머지 페이징 처리
				for (int i = 0; i < total % rowPerPage; i++) {
					prList.add(i, prAllList.get(startRow));
					startRow++;
				}
			} else { // 9페이지가 넘어갈 경우 페이징 처리
				for (int i = 0; i <= 9; i++) {
					prList.add(i, prAllList.get(startRow));
					startRow++;
				}
			}
		} else {
			switch (search) {
			case "title": // 공고명으로 검색
				for (int i = 0; i < prAllList.size(); i++) {
					if (prAllList.get(i).getTitle().contains(keyword))
						prList.add(prAllList.get(i));
				}
				break;
			case "company": // 회사명으로 검색
				for (int i = 0; i < prAllList.size(); i++) {
					if (prAllList.get(i).getCompany().contains(keyword))
						prList.add(prAllList.get(i));
				}
				break;
			case "location": // 위치명으로 검색
				for (int i = 0; i < prAllList.size(); i++) {
					if (prAllList.get(i).getLocation().contains(keyword))
						prList.add(prAllList.get(i));
				}
				break;
			case "positions": // 직무명으로 검색
				for (int i = 0; i < prAllList.size(); i++) {
					if (prAllList.get(i).getPositions().contains(keyword))
						prList.add(prAllList.get(i));
				}
				break;
			default:
				break;
			}
			total = prList.size(); // 검색 대상 데이터 수를 가져옴
			List<ScrapJson> prSearchList = new ArrayList<>(); // 페이징 처리를 위해 잠깐 담아놓을 검색 리스트
			if (currentPage == total / rowPerPage + 1) {
				for (int i = 0; i < total % rowPerPage; i++) {
					prSearchList.add(i, prList.get(startRow));
					startRow++;
				}
			} else {
				for (int i = 0; i <= 9; i++) {
					prSearchList.add(i, prList.get(startRow));
					startRow++;
				}
			}
			// 페이징 처리된 리스트를 다시 담기 위해 비운 후, 페이징 처리된 검색 리스트를 넣어줌
			prList.clear();
			prList.addAll(prSearchList);
		}

		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);

		model.addAttribute("select", select);
		model.addAttribute("prDate", prDate);
		model.addAttribute("prList", prList);
		model.addAttribute("pb", pb);
		model.addAttribute("search", search);
		model.addAttribute("keyword", keyword);

		return "scrap/scrap_programmers";
	}

	@RequestMapping("scrapSaramin") // 사람인 사이트와 연결
	public String scrapSaramin(String pageNum, Model model, String search, String keyword) {

		String fileName = "scrap_result_saramin.json";

		String srDate = ss.getDate(fileName);
		List<ScrapJson> saramAllList = ss.scrapSaramin(fileName);

		if (pageNum == null || pageNum.equals(""))
			pageNum = "1"; // 페이지 번호 여부 확인 및 값 초기화
		int currentPage = Integer.parseInt(pageNum); // 숫자로 변환하여 처리
		int rowPerPage = 10; // 한 화면에 보여지는 게시글 개수
		int startRow = (currentPage - 1) * rowPerPage; // 페이지 내 시작행 설정
		int endRow = startRow + rowPerPage - 1; // 페이지 내 끝행 설정

		// 전체 페이징 처리
		int total = saramAllList.size();

		List<ScrapJson> saramList = new ArrayList<>();
		String[] select = { "공고명", "회사명", "근무지", "직무" }; // 검색 기능 필터 내용 부분

		// 초기 검색이 되지 않을 때 prAllList에서 모든 행을 가져옴
		if (search == null) {
			if (currentPage == total / rowPerPage + 1) { // 9페이지 이하 나머지 페이징 처리
				for (int i = 0; i < total % rowPerPage; i++) {
					saramList.add(i, saramAllList.get(startRow));
					startRow++;
				}
			} else { // 9페이지가 넘어갈 경우 페이징 처리
				for (int i = 0; i <= 9; i++) {
					saramList.add(i, saramAllList.get(startRow));
					startRow++;
				}
			}
		} else {
			switch (search) {
			case "title": // 공고명으로 검색
				for (int i = 0; i < saramAllList.size(); i++) {
					if (saramAllList.get(i).getTitle().contains(keyword))
						saramList.add(saramAllList.get(i));
				}
				break;
			case "company": // 회사명으로 검색
				for (int i = 0; i < saramAllList.size(); i++) {
					if (saramAllList.get(i).getCompany().contains(keyword))
						saramList.add(saramAllList.get(i));
				}
				break;
			case "location": // 위치명으로 검색
				for (int i = 0; i < saramAllList.size(); i++) {
					if (saramAllList.get(i).getLocation().contains(keyword))
						saramList.add(saramAllList.get(i));
				}
				break;
			case "positions": // 직무명으로 검색
				for (int i = 0; i < saramAllList.size(); i++) {
					if (saramAllList.get(i).getPositions().contains(keyword))
						saramList.add(saramAllList.get(i));
				}
				break;
			default:
				break;
			}
			total = saramList.size(); // 검색 대상 데이터 수를 가져옴
			List<ScrapJson> srSearchList = new ArrayList<>(); // 페이징 처리를 위해 잠깐 담아놓을 검색 리스트
			if (currentPage == total / rowPerPage + 1) {
				for (int i = 0; i < total % rowPerPage; i++) {
					srSearchList.add(i, saramList.get(startRow));
					startRow++;
				}
			} else {
				for (int i = 0; i <= 9; i++) {
					srSearchList.add(i, saramList.get(startRow));
					startRow++;
				}
			}
			// 페이징 처리된 리스트를 다시 담기 위해 비운 후, 페이징 처리된 검색 리스트를 넣어줌
			saramList.clear();
			saramList.addAll(srSearchList);
		}

		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);

		model.addAttribute("select", select);
		model.addAttribute("srDate", srDate);
		model.addAttribute("saramList", saramList);
		model.addAttribute("pb", pb);
		model.addAttribute("search", search);
		model.addAttribute("keyword", keyword);

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
			pageNum = "1"; // 페이지 번호 여부 확인 및 값 초기화
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

	@RequestMapping("xlsSave")
	public void xlsSave(HttpServletResponse response, HttpSession session) {

		// 로그인한 id 기준으로 모든 스크랩 공고를 가져옴
		int mem_num = (int) session.getAttribute("mem_num");
		List<Scrap> myxlslist = ss.myxlslist(mem_num);

		// 엑셀 워크북 생성
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("내 스크랩 공고");
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

		// 헤더 스타일 지정
		CellStyle headStyle = wb.createCellStyle();
		// 가는 경계선
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		// 레몬 배경색
		headStyle.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// 데이터 가운데 정렬
		headStyle.setAlignment(HorizontalAlignment.CENTER);

		// 데이터 출력 스타일 지정
		CellStyle bodyStyle = wb.createCellStyle();
		// 가는 경계선
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);

		// 헤더 생성
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0); // 0번부터 셀 컬럼 하나씩 추가
		cell.setCellStyle(headStyle);
		cell.setCellValue("공고출처");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("공고명");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("회사명");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("근무지");
		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("경력");
		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("공고 URL");

		// 리스트에서 데이터를 입력해줌
		for (Scrap scrap : myxlslist) {

			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(scrap.getScrap_from());
			if (cell.getStringCellValue().equals("1")) {
				cell.setCellValue("프로그래머스");
			} else
				cell.setCellValue("사람인");
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(scrap.getScrap_title());
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(scrap.getScrap_company());
			cell = row.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(scrap.getScrap_location());
			cell = row.createCell(4);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(scrap.getScrap_career());
			cell = row.createCell(5);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(scrap.getScrap_link());
		}
		wb.getSheet("내 스크랩 공고").autoSizeColumn(0);
		wb.getSheet("내 스크랩 공고").autoSizeColumn(1);
		wb.getSheet("내 스크랩 공고").autoSizeColumn(2);
		wb.getSheet("내 스크랩 공고").autoSizeColumn(3);
		wb.getSheet("내 스크랩 공고").autoSizeColumn(4);
		wb.getSheet("내 스크랩 공고").autoSizeColumn(5);
		// 엑셀 출력
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=MyScrapList.xlsx");
		try {
			wb.write(response.getOutputStream());
			wb.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
