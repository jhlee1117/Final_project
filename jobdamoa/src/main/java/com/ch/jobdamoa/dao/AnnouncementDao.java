package com.ch.jobdamoa.dao;

import java.util.List;

import com.ch.jobdamoa.model.Announcement;

public interface AnnouncementDao {

	List<Announcement> annList(Announcement ann);

	int getTotal();

}
