package com.ch.jobdamoa.dao;

import java.util.List;

import com.ch.jobdamoa.model.Manager;
import com.ch.jobdamoa.model.Member;

public interface ManagerDao {
	
	int update(Member member);
	int delete(String mem_id);
	int restore(String mem_id);
	Manager login(String manager_id);
	int getTotal();
	List<Member> memberList(int startRow, int endRow);
}
