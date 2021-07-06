package com.ch.jobdamoa.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Company {

	private int com_num; // 기업회원번호
	private String com_id; // 아이디
	private String com_password; // 비밀번호
	private Date com_join_date; // 가입일
	private String com_email; // 대표이메일
	private String com_business_num; // 사업자등록번호
	private String com_name; // 회사명
	private String com_homepage; // 회사홈페이지
	private int com_emp_num; // 사원수
	private int com_sales; // 매출
	private String com_invalid; // 탈퇴여부
	private String com_address; // 회사주소
	private String com_pno; // 회사전화번호
	private String user_dist; // 회원구분
	
}
