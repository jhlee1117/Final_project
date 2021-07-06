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
}
