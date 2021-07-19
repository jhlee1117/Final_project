package com.ch.jobdamoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jobdamoa.dao.ManagerDao;
import com.ch.jobdamoa.dao.MemberDao;
import com.ch.jobdamoa.model.Manager;
import com.ch.jobdamoa.model.Member;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired private ManagerDao md;

	@Override
	public int update(Member member) {
		return md.update(member);
	}

	@Override
	public int delete(String mem_id) {
		return md.delete(mem_id);
	}

	@Override
	public int restore(String mem_id) {
		return md.restore(mem_id);
	}

	@Override
	public Manager login(String manager_id) {
		return md.login(manager_id);
	}

	@Override
	public int getTotal() {
		return md.getTotal();
	}

	@Override
	public List<Member> memberList(int startRow, int endRow) {
		return md.memberList(startRow, endRow);
	}
}
