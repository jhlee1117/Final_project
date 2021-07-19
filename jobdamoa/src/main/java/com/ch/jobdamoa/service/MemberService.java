package com.ch.jobdamoa.service;

import com.ch.jobdamoa.model.Member;

public interface MemberService {

	Member selectLogin(String mem_id);

	Member findMemId(String mem_email);

	int newMemPw(Member mem);
}
