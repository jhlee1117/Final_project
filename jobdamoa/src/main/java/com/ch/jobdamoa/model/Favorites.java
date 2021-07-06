package com.ch.jobdamoa.model;

import lombok.Data;

@Data
public class Favorites {
    
	private int fav_num; // 즐겨찾기번호
	private int mem_num; // 회원번호(fk)
    private int ann_num; // 기업공고번호(fk)
}
