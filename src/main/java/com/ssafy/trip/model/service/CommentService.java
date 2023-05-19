package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.trip.dto.Comment;
import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.dto.SearchCondition;

public interface CommentService {
	int insert(Comment comment) throws SQLException;
	int update(Comment comment) throws SQLException;
	int delete(int id) throws SQLException;
	List<Comment> selectAll(int notice_id) throws SQLException;
}
