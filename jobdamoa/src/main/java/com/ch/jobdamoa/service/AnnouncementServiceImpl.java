package com.ch.jobdamoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jobdamoa.dao.AnnouncementDao;
import com.ch.jobdamoa.model.Announcement;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	
	@Autowired
	private AnnouncementDao ad;

	@Override
	public List<Announcement> annList(Announcement ann) {
		return ad.annList(ann);
	}

	@Override
	public int getTotal() {
		return ad.getTotal();
	}

	@Override
	public int getMaxNum() {
		return ad.getMaxNum();
	}

	@Override
	public int annInsert(Announcement ann) {
		return ad.annInsert(ann);
	}

	@Override
	public void updateReadCount(int ann_num) {
		ad.updateReadCount(ann_num);
		
	}

	@Override
	public Announcement annView(int ann_num) {
		return ad.annView(ann_num);
	}

	@Override
	public List<Announcement> myAnnList(Announcement ann) {
		return ad.myAnnList(ann);
	}

	@Override
	public int getMyTotal(int com_num) {
		return ad.getMyTotal(com_num);
	}

	@Override
	public int annUpdate(Announcement ann) {
		return ad.annUpdate(ann);
	}

	@Override
	public int annDelete(int ann_num) {
		// TODO Auto-generated method stub
		return ad.annDelete(ann_num);
	}
}
