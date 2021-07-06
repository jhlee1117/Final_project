package com.ch.jobdamoa.model;

import lombok.Data;

@Data
public class Manager {
	
    private String manager_id; // 관리자 ID
    private String manager_password; // 관리자 비밀번호
    private String user_dist; // 회원구분
    private int manager_num; // 관리자번호
}
