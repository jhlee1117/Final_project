package com.ch.jobdamoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jobdamoa.dao.ManagerDao;
import com.ch.jobdamoa.model.Company;
import com.ch.jobdamoa.model.Manager;
import com.ch.jobdamoa.model.Member;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao md;

	@Override
	public Manager login(String manager_id) {
		return md.login(manager_id);
	}
	
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
	public int getTotal() {
		return md.getTotal();
	}

	@Override
	public List<Member> memberList(int startRow, int endRow) {
		return md.memberList(startRow, endRow);
	}

	@Override
	public String chkMember(String mem_id) {
		return md.chkMember(mem_id);
	}

	@Override
	public int companyDelete(String com_id) {
		return md.companyDelete(com_id);
	}

	@Override
	public int companyRestore(String com_id) {
		return md.companyRestore(com_id);
	}

	@Override
	public int getCompanyTotal() {
		return md.getCompanyTotal();
	}

	@Override
	public List<Company> companyList(int startRow, int endRow) {
		return md.companyList(startRow, endRow);
	}

	@Override
	public String chkCompany(String com_id) {
		return md.chkCompany(com_id);
	}
}
