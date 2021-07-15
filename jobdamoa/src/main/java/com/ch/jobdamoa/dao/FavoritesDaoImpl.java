package com.ch.jobdamoa.dao;

import java.util.List;

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

	@Override
	public List<Favorites> favList(Favorites fav) {
		return sst.selectList("favoritesns.favList", fav);
	}

	@Override
	public int getMyTotal(int mem_num) {
		return sst.selectOne("favoritesns.getMyTotal", mem_num);
	}

	@Override
	public List<Favorites> confirmFavAnn(int ann_num) {
		return sst.selectList("favoritesns.confirmFavAnn", ann_num);
	}

	@Override
	public void favDelete(int ann_num) {
		sst.delete("favoritesns.favDelete", ann_num);
		
	}
}
