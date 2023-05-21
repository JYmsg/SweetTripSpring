package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.LikeHotPlace;
import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.dto.SearchCondition;

@Mapper
public interface LikeHotPlaceRepo {
	int insert(LikeHotPlace likehotplace) throws SQLException;
	int delete(String user_id, int hotplace_id) throws SQLException;
	List<LikeHotPlace> select(String user_id) throws SQLException;
}
