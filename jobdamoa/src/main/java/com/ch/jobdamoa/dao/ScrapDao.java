package com.ch.jobdamoa.dao;

import com.ch.jobdamoa.model.Scrap;

public interface ScrapDao {

	Scrap confirmScrap(Scrap scchk);

	int getMaxNum();

	int scrapSave(Scrap scrap2);

}
