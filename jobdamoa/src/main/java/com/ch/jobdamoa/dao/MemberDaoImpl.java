package com.ch.jobdamoa.dao;


import java.util.List;
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

	@Override
	public int giveMem_num() {
		return sst.selectOne("memberns.giveMem_num");
	}

	@Override
	public List<Member> selectMem_email(String mem_email) {
		return sst.selectList("memberns.selectMem_email", mem_email);
	}

	@Override
	public int insertMem(Member mem) {
		return sst.insert("memberns.insertMem", mem);
	}

	@Override
	public Member selectMem(int mem_num) {
		return sst.selectOne("memberns.selectMem", mem_num);
	}

	@Override
	public int updateMem(Member mem) {
		return sst.update("memberns.updateMem", mem);
	}

	@Override
	public int deleteMem(int mem_num) {
		return sst.update("memberns.deleteMem", mem_num);
	}
}
