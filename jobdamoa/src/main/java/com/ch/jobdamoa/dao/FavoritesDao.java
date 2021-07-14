package com.ch.jobdamoa.dao;

import java.util.List;
import java.util.Map;

import com.ch.jobdamoa.model.Favorites;

public interface FavoritesDao {

	Favorites confirmFav(Favorites favchk);

	int getMaxNum();

	int favSave(Favorites fav);

}
