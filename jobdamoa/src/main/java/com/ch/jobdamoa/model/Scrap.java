package com.ch.jobdamoa.model;

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
}
