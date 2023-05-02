package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.Place;

@Mapper
public interface HotPlaceRepo {
	int insert(HotPlace hotplace) throws SQLException;
	int update(HotPlace hotplace) throws SQLException;
	int delete(int id) throws SQLException;
	HotPlace select(int id) throws SQLException;
	List<HotPlace> selectAll() throws SQLException;
}
