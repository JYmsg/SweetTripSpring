package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Travel;

@Mapper
public interface TravelRepo {
	int insert(Travel travel) throws SQLException;
	int update(Travel travel) throws SQLException;
	int delete(int id) throws SQLException;
	int last() throws SQLException;
	Travel select(int id) throws SQLException;
	List<Travel> selectAll(String user_id) throws SQLException;
}
