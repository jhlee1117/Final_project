package com.ch.jobdamoa.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnnouncementDaoImpl implements AnnouncementDao {
	
	@Autowired
	private SqlSessionTemplate sst;
}
