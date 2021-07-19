package com.ch.jobdamoa.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.jobdamoa.model.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Company selectCom_nm(int com_num) {
		return sst.selectOne("companyns.selectCom_nm", com_num);
	}

	@Override
	public Company selectCom(int com_num) {
		return sst.selectOne("companyns.selectCom", com_num);
	}

	@Override
	public Company selectLogin(String com_id) {
		return sst.selectOne("companyns.selectLogin", com_id);
	}

	@Override
	public Company findComId(String com_email) {
		return sst.selectOne("companyns.findComId", com_email);
	}

	@Override
	public int newComPw(Company com) {
		return sst.update("companyns.newComPw", com);
	}

	@Override
	public List<Company> selectCom_bnm(String com_business_num) {
		return sst.selectList("companyns.selectCom_bnm", com_business_num);
	}

	@Override
	public List<Company> selectCom_email(String com_email) {
		return sst.selectList("companyns.selectCom_email", com_email);
	}

	@Override
	public List<Company> selectCom_pno(String com_pno) {
		return sst.selectList("companyns.selectCom_pno", com_pno);
	}

	@Override
	public int insertCom(Company com) {
		return sst.insert("companyns.insertCom", com);
	}

	@Override
	public int giveCom_num() {
		return sst.selectOne("companyns.giveCom_num");
	}

	@Override
	public int updateCom(Company com) {
		return sst.update("companyns.updateCom", com);
	}

	@Override
	public int deleteCom(int com_num) {
		return sst.update("companyns.deleteCom", com_num);
	}
}
