package com.ch.jobdamoa.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScrapDaoImpl implements ScrapDao {
	
	@Autowired
	private SqlSessionTemplate sst;
}
