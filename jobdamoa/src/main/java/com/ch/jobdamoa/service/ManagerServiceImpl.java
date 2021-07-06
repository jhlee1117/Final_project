package com.ch.jobdamoa.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ch.jobdamoa.dao.ManagerDao;

public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao md;
}
