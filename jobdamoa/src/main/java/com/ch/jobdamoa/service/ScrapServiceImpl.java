package com.ch.jobdamoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jobdamoa.dao.ScrapDao;

@Service
public class ScrapServiceImpl implements ScrapService {

	@Autowired
	private ScrapDao sd;
}
