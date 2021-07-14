package com.ch.jobdamoa.service;

import java.util.List;
import java.util.Map;

import com.ch.jobdamoa.model.Favorites;

public interface FavoritesService {

	List<Map<String, Favorites>> confirmFav(int mem_num);

	int getMaxNum();

	int favSave(Favorites fav);

}
