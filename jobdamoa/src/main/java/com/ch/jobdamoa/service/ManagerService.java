package com.ch.jobdamoa.service;

import java.util.List;

import com.ch.jobdamoa.model.Company;
import com.ch.jobdamoa.model.Manager;
import com.ch.jobdamoa.model.Member;

public interface ManagerService {
	
	Manager select(String manager_id);
	
	//일반 회원 관리
	int update(Member member); //회원 정보 수정
	
	int delete(String mem_id); //회원 탈퇴
	
	int restore(String mem_id); //회원 복구
	
	int getTotal(); //회원 수 확인

	List<Member> memberList(int startRow, int endRow); //회원 리스트
	
	String chkMember(String mem_id); //회원 탈퇴 여부 확인
	
	//기업 회원 관리
	int companyDelete(String com_id);
	
	int companyRestore(String com_id);
	
	int getCompanyTotal();
	
	List<Company> companyList(int startRow, int endRow);
	
	String chkCompany(String com_id);
}
