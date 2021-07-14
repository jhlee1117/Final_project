package com.ch.jobdamoa.service;

import java.util.List;
import java.util.Map;

import com.ch.jobdamoa.model.Favorites;

public interface FavoritesService {

	Favorites confirmFav(Favorites favchk);

	int getMaxNum();

	int favSave(Favorites fav);

}
