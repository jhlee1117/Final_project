package com.ch.jobdamoa.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.jobdamoa.model.Favorites;
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

	@Override
	public int getMyTotal(int mem_num) {
		return sst.selectOne("scrapns.getMyTotal", mem_num);
	}

	@Override
	public List<Scrap> scrapList(Scrap scrap) {
		return sst.selectList("scrapns.scrapList", scrap);
	}

	@Override
	public int scrapDelete(int scrap_num) {
		return sst.delete("scrapns.scrapDelete", scrap_num);
	}

	@Override
	public List<Scrap> myxlslist(int mem_num) {
		return sst.selectList("scrapns.myxlslist", mem_num);
	}
}
