package com.ch.jobdamoa.dao;

import java.util.List;

import com.ch.jobdamoa.model.Company;
import com.ch.jobdamoa.model.Manager;
import com.ch.jobdamoa.model.Member;

public interface ManagerDao {
	
	Manager select(String manager_id);
	
	//일반 회원 관리
	int update(Member member);
	
	int delete(String mem_id);
	
	int restore(String mem_id);
	
	int getTotal();
	
	List<Member> memberList(int startRow, int endRow);
	
	String chkMember(String mem_id);
	
	//기업 회원 관리
	int companyUpdate(Company company);
	
	int companyDelete(String com_id);
	
	int companyRestore(String com_id);
	
	int getCompanyTotal();
	
	List<Company> companyList(int startRow, int endRow);
	
	String chkCompany(String com_id);
	
}
