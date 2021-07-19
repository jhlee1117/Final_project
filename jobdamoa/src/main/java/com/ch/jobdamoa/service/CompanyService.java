package com.ch.jobdamoa.service;

import java.util.List;

import com.ch.jobdamoa.model.Company;

public interface CompanyService {

	Company selectCom_nm(int com_num);

	Company selectCom(int com_num);

	Company selectLogin(String com_id);

	Company findComId(String com_email);

	int newComPw(Company com);

	List<Company> selectCom_bnm(String com_business_num);

	List<Company> selectCom_email(String com_email);

	List<Company> selectCom_pno(String com_pno);

	int insertCom(Company com);

	int giveCom_num();

	int updateCom(Company com);

	int deleteCom(int com_num);

}
