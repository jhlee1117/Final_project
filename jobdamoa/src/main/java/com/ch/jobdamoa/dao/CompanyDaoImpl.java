package com.ch.jobdamoa.dao;

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
}
