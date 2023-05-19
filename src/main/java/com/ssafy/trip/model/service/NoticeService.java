package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.dto.SearchCondition;

public interface NoticeService {
	int insert(Notice notice) throws SQLException;
	int update(Notice notice) throws SQLException;
	int delete(int id) throws SQLException;
	Notice select(int id) throws SQLException;
	List<Notice> selectAll() throws SQLException;
	
	int update_hit(Notice notice) throws SQLException;
	
	List<Notice> search(SearchCondition condition) throws SQLException;
	Map<String, Object> pagingSearch(SearchCondition condition) throws SQLException;
}
