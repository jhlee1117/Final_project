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
		return sst.insert("announcementns.annInsert", ann);
	}

	@Override
	public void updateReadCount(int ann_num) {
		sst.update("announcementns.updateReadCount", ann_num);
	}

	@Override
	public Announcement annView(int ann_num) {
		return sst.selectOne("announcementns.annView", ann_num);
	}

	@Override
	public List<Announcement> myAnnList(Announcement ann) {
		return sst.selectList("announcementns.myAnnList", ann);
	}

	@Override
	public int getMyTotal(int com_num) {
		return sst.selectOne("announcementns.getMyTotal", com_num);
	}

	@Override
	public int annUpdate(Announcement ann) {
		return sst.update("announcementns.annUpdate", ann);
	}

	@Override
	public int annDelete(int ann_num) {
		return sst.update("announcementns.annDelete", ann_num);
	}
}
