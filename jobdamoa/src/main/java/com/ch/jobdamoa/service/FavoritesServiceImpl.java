package com.ch.jobdamoa.service;

import java.util.List;

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

	@Override
	public List<Favorites> favList(Favorites fav) {
		return fd.favList(fav);
	}

	@Override
	public int getMyTotal(int mem_num) {
		return fd.getMyTotal(mem_num);
	}

	@Override
	public List<Favorites> confirmFavAnn(int ann_num) {
		return fd.confirmFavAnn(ann_num);
	}

	@Override
	public void favDelete(int ann_num) {
		fd.favDelete(ann_num);
		
	}
}
