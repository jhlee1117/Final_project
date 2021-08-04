package com.ch.jobdamoa.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Announcement {
	
	private int ann_num; // 기업공고번호
	private int com_num; // 기업회원번호(fk)
	private String ann_job; // 직무 
	private String ann_type; // 고용형태
	private String ann_career; // 경력
	private String ann_recruit_period; // 기간
	private String ann_location; // 근무위치
	private String ann_title; // 타이틀
    private int	ann_view; // 조회수
	private String ann_del; // 공고삭제여부
	private int ann_min; // 최소급여
	private int ann_max; // 최대급여
	private String ann_contents; // 업무소개
	private String ann_qualification; // 자격요건
	private String ann_prime; // 우대사항
	private Date ann_regdate; // 공고작성일
	
	// paging용
	private int startRow;
	private int endRow;
	// 검색용
	private String search;
	private String keyword;
	// 회사정보 조회용
	private String com_name;
	
	
}
