package com.ch.jobdamoa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.jobdamoa.model.Manager;
import com.ch.jobdamoa.model.Member;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private SqlSessionTemplate sst;
	
	@Override
	public int update(Member member) {
		return sst.update("managerns.update", member);
	}
	
	@Override
	public int delete(String mem_id) {
		return sst.update("managerns.delete", mem_id);
	}
	
	@Override
	public int restore(String mem_id) {
		return sst.update("managerns.restore", mem_id);
	}

	@Override
	public Manager login(String manager_id) {
		return sst.selectOne("managerns.select", manager_id);
	}

	@Override
	public int getTotal() {
		return (int) sst.selectOne("managerns.total");
	}
	
	@Override
	public List<Member> memberList(int startRow, int endRow) {
		Map<String, Integer> parms = new HashMap<String, Integer>();
		parms.put("startRow", startRow);
		parms.put("endRow", endRow);
		return sst.selectList("managerns.memberList", parms);
	}
}
