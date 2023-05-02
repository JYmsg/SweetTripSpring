package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.dto.Review;
import com.ssafy.trip.dto.SearchCondition;

public interface ReviewService {
	int insert(Review review) throws SQLException;
	int update(Review review) throws SQLException;
	int delete(String writer_id, int travel_id) throws SQLException;
	Review select(String writer_id, int travel_id) throws SQLException;
	List<Review> selectAll() throws SQLException;
	
	List<Review> search(SearchCondition condition) throws SQLException;
	Map<String, Object> pagingSearch(SearchCondition condition) throws SQLException;
}
