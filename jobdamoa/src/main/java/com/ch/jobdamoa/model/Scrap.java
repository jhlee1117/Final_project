package com.ch.jobdamoa.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Scrap {
	
	private int scrap_num; // 즐겨찾기 번호
    private int mem_num; // 회원번호 (fk)
    private String scrap_title; // 타이틀
    private String scrap_company; // 회사
    private String scrap_location; // 위치
    private String scrap_career; // 경험
    private String scrap_link; // 링크
    private Date scrap_date; // 추가한 날짜
    
    private String scrap_from; // 어디서 추가한 공고인지 구분하기 위함 (1: 프로그래머스, 2: 사람인...)
    
	// paging용
	private int startRow;
	private int endRow;
	
//	public String getScrap_from() {
//		String data = "";
//		if (scrap_from.equals("1")) {
//			data = "프로그래머스";
//		} else if (scrap_from.equals("2")) {
//			data = "사람인";
//		}
//		return data;
//	}
}
