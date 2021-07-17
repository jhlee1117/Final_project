package com.ch.jobdamoa.dao;

import java.util.List;

import com.ch.jobdamoa.model.Member;

public interface MemberDao {

	Member selectLogin(String mem_id);

	Member findMemId(String mem_email);

	int newMemPw(Member mem);

	int giveMem_num();

	List<Member> selectMem_email(String mem_email);

	int insertMem(Member mem);

}
