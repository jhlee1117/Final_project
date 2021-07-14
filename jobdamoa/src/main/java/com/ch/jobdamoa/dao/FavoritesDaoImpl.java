package com.ch.jobdamoa.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.jobdamoa.model.Favorites;

@Repository
public class FavoritesDaoImpl implements FavoritesDao {
	
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public List<Map<String, Favorites>> confirmFav(int mem_num) {
		return sst.selectList("favoritesns.confirmFav", mem_num);
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
