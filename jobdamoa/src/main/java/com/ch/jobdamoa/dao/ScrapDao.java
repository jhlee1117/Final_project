package com.ch.jobdamoa.dao;

import java.util.List;

import com.ch.jobdamoa.model.Scrap;

public interface ScrapDao {

	Scrap confirmScrap(Scrap scchk);

	int getMaxNum();

	int scrapSave(Scrap scrap2);

	int getMyTotal(int mem_num);

	List<Scrap> scrapList(Scrap scrap);

	int scrapDelete(int scrap_num);

	List<Scrap> myxlslist(int mem_num);

}
