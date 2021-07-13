package com.ch.jobdamoa.dao;

import java.util.List;
import java.util.Map;

import com.ch.jobdamoa.model.Favorites;

public interface FavoritesDao {

	List<Favorites> confirmFav(int mem_num);

	int getMaxNum();

	int favSave(Favorites fav);

}
