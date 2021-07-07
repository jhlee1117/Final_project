package com.ch.jobdamoa.service;

import java.util.List;

import com.ch.jobdamoa.model.Announcement;

public interface AnnouncementService {

	List<Announcement> annList(Announcement ann);

	int getTotal();

	int getMaxNum();

	int annInsert(Announcement ann);

}
