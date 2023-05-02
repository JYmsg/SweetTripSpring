package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.dto.Review;
import com.ssafy.trip.dto.SearchCondition;

@Mapper
public interface ReviewRepo {
	int insert(Review review) throws SQLException;
	int update(Review review) throws SQLException;
	int delete(String writer_id, int travel_id) throws SQLException;
	Review select(String writer_id, int travel_id) throws SQLException;
	List<Review> selectAll() throws SQLException;
	
	List<Review> search(SearchCondition condition) throws SQLException;
	int getTotalSearchCount(SearchCondition condition) throws SQLException;
}
