package com.ch.jobdamoa.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {
	
    private int mem_num; // 회원번호
    private String mem_id; // 아이디
    private String mem_password; // 비밀번호
    private String mem_nickname; // 닉네임
    private Date mem_join_date; // 가입일
    private String mem_email; // 이메일
    private String mem_invalid; // 탈퇴여부
    private String user_dist; // 회원구분
}
