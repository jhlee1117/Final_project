package com.ch.jobdamoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jobdamoa.dao.MemberDao;
import com.ch.jobdamoa.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao md;

	@Override
	public Member selectLogin(String mem_id) {
		return md.selectLogin(mem_id);
	}

	@Override
	public Member findMemId(String mem_email) {
		return md.findMemId(mem_email);
	}

	@Override
	public int newMemPw(Member mem) {
		return md.newMemPw(mem);
	}
}
