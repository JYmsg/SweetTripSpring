package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Travel;

public interface TravelService {
	int insert(Travel travel) throws SQLException;
	int update(Travel travel) throws SQLException;
	int delete(int id) throws SQLException;
	Travel select(int id) throws SQLException;
	List<Travel> selectAll(String user_id) throws SQLException;
}
