package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Day;

@Mapper
public interface DayRepo {
	int insert(Day day) throws SQLException;
	int update(Day day) throws SQLException;
	int delete(int id) throws SQLException;
	Day select(int id) throws SQLException;
	int insertAttraction(int id, int attraction_id) throws SQLException;
	int deleteAttraction(int id) throws SQLException;
	int deleteoneAttraction(int id, int content_id) throws SQLException;
	List<Integer> selectAttraction(int id) throws SQLException;
	List<Day> selectAll(int travel_id) throws SQLException;
}
