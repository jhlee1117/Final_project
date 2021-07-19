package com.ch.jobdamoa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.jobdamoa.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Member selectLogin(String mem_id) {
		return sst.selectOne("memberns.selectLogin", mem_id);
	}

	@Override
	public Member findMemId(String mem_email) {
		return sst.selectOne("memberns.findMemId", mem_email);
	}

	@Override
	public int newMemPw(Member mem) {
		return sst.update("memberns.newMemPw", mem);
	}
}
