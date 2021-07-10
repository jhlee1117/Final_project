package com.ch.jobdamoa.service;

import com.ch.jobdamoa.model.Company;

public interface CompanyService {

	Company selectCom_nm(int com_num);

	Company selectCom(int com_num);

	Company selectLogin(String com_id);

	Company findComId(String com_email);

	int newComPw(Company com);

}
