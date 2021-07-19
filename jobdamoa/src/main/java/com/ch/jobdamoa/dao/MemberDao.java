package com.ch.jobdamoa.dao;

import com.ch.jobdamoa.model.Member;

public interface MemberDao {

	Member selectLogin(String mem_id);

	Member findMemId(String mem_email);

	int newMemPw(Member mem);
}
