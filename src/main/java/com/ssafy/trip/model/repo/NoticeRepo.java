package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.dto.SearchCondition;

@Mapper
public interface NoticeRepo {
	int insert(Notice notice) throws SQLException;
	int update(Notice notice) throws SQLException;
	int delete(int id) throws SQLException;
	Notice select(int id) throws SQLException;
	List<Notice> selectAll() throws SQLException;
	
	
	List<Notice> search(SearchCondition condition) throws SQLException;
	int getTotalSearchCount(SearchCondition condition) throws SQLException;
}
