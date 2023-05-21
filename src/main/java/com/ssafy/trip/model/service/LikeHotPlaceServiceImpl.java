package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.LikeHotPlace;
import com.ssafy.trip.model.repo.LikeHotPlaceRepo;

@Service
public class LikeHotPlaceServiceImpl implements LikeHotPlaceService {

	@Autowired
	private LikeHotPlaceRepo repo;
	
	@Override
	public int insert(LikeHotPlace likehotplace) throws SQLException {
		return repo.insert(likehotplace);
	}

	@Override
	public int delete(String user_id, int hotplace_id) throws SQLException {
		return repo.delete(user_id, hotplace_id);
	}

	@Override
	public List<LikeHotPlace> select(String user_id) throws SQLException {
		return repo.select(user_id);
	}

}
