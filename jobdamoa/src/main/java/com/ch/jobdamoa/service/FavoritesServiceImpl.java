package com.ch.jobdamoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.jobdamoa.dao.FavoritesDao;
import com.ch.jobdamoa.model.Favorites;

@Service
public class FavoritesServiceImpl implements FavoritesService {
	
	@Autowired
	private FavoritesDao fd;

	@Override
	public Favorites confirmFav(Favorites favchk) {
		return fd.confirmFav(favchk);
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
