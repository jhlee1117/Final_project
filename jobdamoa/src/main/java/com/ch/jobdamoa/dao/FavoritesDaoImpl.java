package com.ch.jobdamoa.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.jobdamoa.model.Favorites;

@Repository
public class FavoritesDaoImpl implements FavoritesDao {
	
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Favorites confirmFav(Favorites favchk) {
		return sst.selectOne("favoritesns.confirmFav", favchk);
	}

	@Override
	public int getMaxNum() {
		return sst.selectOne("favoritesns.getMaxNum");
	}

	@Override
	public int favSave(Favorites fav) {
		return sst.insert("favoritesns.favSave", fav);
	}
}
