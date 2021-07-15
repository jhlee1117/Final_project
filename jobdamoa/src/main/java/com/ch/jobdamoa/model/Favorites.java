package com.ch.jobdamoa.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Favorites {
    
	private int fav_num; // 즐겨찾기번호
	private int mem_num; // 회원번호(fk)
    private int ann_num; // 기업공고번호(fk)
    private Date fav_date; // 즐겨찾기 추가시점
    
	// paging용
	private int startRow;
	private int endRow;
	
	// join용
	private Announcement announcement;
	private Company company;
}
