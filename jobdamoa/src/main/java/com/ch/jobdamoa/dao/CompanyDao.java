package com.ch.jobdamoa.dao;

import com.ch.jobdamoa.model.Company;

public interface CompanyDao {

	Company selectCom_nm(int com_num);

	Company selectCom(int com_num);

	Company selectLogin(String com_id);

	Company findComId(String com_email);

}
