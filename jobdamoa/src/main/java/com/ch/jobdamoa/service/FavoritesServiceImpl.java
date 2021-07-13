package com.ch.jobdamoa.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jobdamoa.dao.FavoritesDao;
import com.ch.jobdamoa.model.Favorites;

@Service
public class FavoritesServiceImpl implements FavoritesService {
	
	@Autowired
	private FavoritesDao fd;

	@Override
	public List<Favorites> confirmFav(int mem_num) {
		return fd.confirmFav(mem_num);
	}

	@Override
	public int getMaxNum() {
		return fd.getMaxNum();
	}

	@Override
	public int favSave(Favorites fav) {
		return fd.favSave(fav);
	}
}
