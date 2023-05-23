package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.trip.dto.Day;
import com.ssafy.trip.dto.Place;

public interface DayService {
	int insert(Day day) throws SQLException;
	int update(Day day) throws SQLException;
	int delete(int id) throws SQLException;
	Day select(int id) throws SQLException;
	int insertAttraction(int id, int attraction_id) throws SQLException;
	int deleteAttraction(int id) throws SQLException;
	Place selectoneAttraction(int day_id, int content_id) throws SQLException;
	List<Integer> selectAttraction(int id) throws SQLException;
	List<Day> selectAll(int travel_id) throws SQLException;
}
