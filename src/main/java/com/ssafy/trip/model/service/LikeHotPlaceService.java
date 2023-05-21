package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.LikeHotPlace;
import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.dto.SearchCondition;

public interface LikeHotPlaceService {
	int insert(LikeHotPlace likehotplace) throws SQLException;
	int delete(String user_id, int hotplace_id) throws SQLException;
	List<LikeHotPlace> select(String user_id) throws SQLException;
}
