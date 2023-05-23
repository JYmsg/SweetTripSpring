package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Day;
import com.ssafy.trip.dto.Place;

@Mapper
public interface DayRepo {
	// day 관련
	int insert(Day day) throws SQLException;
	int update(Day day) throws SQLException;
	int delete(int id) throws SQLException;
	Day select(int id) throws SQLException;
	List<Day> selectAll(int travel_id) throws SQLException;
	// attraction 연결 관련
	List<Integer> selectAllAttraction(int id) throws SQLException;
	List<Place> selectAttraction(int id) throws SQLException;
	Place selectoneAttraction(int day_id, int content_id) throws SQLException;
	int deleteoneAttraction(int id, int content_id) throws SQLException;
	int insertAttraction(int id, int attraction_id, String starttime, String endtime, String memo, int turn) throws SQLException;
	int deleteAttraction(int id) throws SQLException;
	int updateAttraction(int id, int attraction_id, String starttime, String endtime, String memo, int turn) throws SQLException;
}
