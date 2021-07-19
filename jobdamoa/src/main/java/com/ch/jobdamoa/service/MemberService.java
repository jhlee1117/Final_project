package com.ch.jobdamoa.service;

import java.util.List;

import com.ch.jobdamoa.model.Member;

public interface MemberService {

	Member selectLogin(String mem_id);

	Member findMemId(String mem_email);

	int newMemPw(Member mem);

	int giveMem_num();

	List<Member> selectMem_email(String mem_email);

	int insertMem(Member mem);

	Member selectMem(int mem_num);

	int updateMem(Member mem);

	int deleteMem(int mem_num);

}
