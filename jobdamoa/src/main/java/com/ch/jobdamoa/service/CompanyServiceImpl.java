package com.ch.jobdamoa.service;

import java.util.List;

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

	@Override
	public List<Company> selectCom_bnm(String com_business_num) {
		return cd.selectCom_bnm(com_business_num);
	}

	@Override
	public List<Company> selectCom_email(String com_email) {
		return cd.selectCom_email(com_email);
	}

	@Override
	public List<Company> selectCom_pno(String com_pno) {
		return cd.selectCom_pno(com_pno);
	}

	@Override
	public int insertCom(Company com) {
		return cd.insertCom(com);
	}

	@Override
	public int giveCom_num() {
		return cd.giveCom_num();
	}

	@Override
	public int updateCom(Company com) {
		return cd.updateCom(com);
	}

	@Override
	public int deleteCom(int com_num) {
		return cd.deleteCom(com_num);
	}
}
