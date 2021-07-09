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
}
