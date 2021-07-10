package com.ch.jobdamoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jobdamoa.dao.CompanyDao;
import com.ch.jobdamoa.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao cd;

	@Override
	public Company selectCom_nm(int com_num) {
		return cd.selectCom_nm(com_num);
	}

	@Override
	public Company selectCom(int com_num) {
		return cd.selectCom(com_num);
	}

	@Override
	public Company selectLogin(String com_id) {
		return cd.selectLogin(com_id);
	}

	@Override
	public Company findComId(String com_email) {
		return cd.findComId(com_email);
	}

	@Override
	public int newComPw(Company com) {
		return cd.newComPw(com);
	}
}
