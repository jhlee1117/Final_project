package com.ch.jobdamoa.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.jobdamoa.model.Announcement;

@Repository
public class AnnouncementDaoImpl implements AnnouncementDao {
	
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public List<Announcement> annList(Announcement ann) {
		return sst.selectList("announcementns.annList", ann);
	}

	@Override
	public int getTotal() {
		return sst.selectOne("announcementns.getTotal");
	}

	@Override
	public int getMaxNum() {
		return sst.selectOne("announcementns.getMaxNum");
	}
	
	@Override
	public int annInsert(Announcement ann) {
		return sst.insert("announcementns.annInsert");
	}
}
