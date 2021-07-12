package com.ch.jobdamoa.dao;

import java.util.List;

import com.ch.jobdamoa.model.Announcement;

public interface AnnouncementDao {

	List<Announcement> annList(Announcement ann);

	int getTotal();

	int getMaxNum();

	int annInsert(Announcement ann);

	void updateReadCount(int ann_num);

	Announcement annView(int ann_num);

	List<Announcement> myAnnList(Announcement ann);

	int getMyTotal(int com_num);

	int annUpdate(Announcement ann);

	int annDelete(int ann_num);

}
