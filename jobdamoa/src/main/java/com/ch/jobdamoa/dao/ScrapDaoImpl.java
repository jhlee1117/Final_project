package com.ch.jobdamoa.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.jobdamoa.model.Scrap;

@Repository
public class ScrapDaoImpl implements ScrapDao {
	
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Scrap confirmScrap(Scrap scchk) {
		return sst.selectOne("scrapns.confirmScrap", scchk);
	}

	@Override
	public int getMaxNum() {
		return sst.selectOne("scrapns.getMaxNum");
	}

	@Override
	public int scrapSave(Scrap scrap2) {
		return sst.insert("scrapns.scrapSave", scrap2);
	}
}
