package com.ch.jobdamoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jobdamoa.dao.FavoritesDao;

@Service
public class FavoritesServiceImpl implements FavoritesService {
	
	@Autowired
	private FavoritesDao fd;
}
