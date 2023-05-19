package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Comment;

@Mapper
public interface CommentRepo {
	int insert(Comment comment) throws SQLException;
	int update(Comment comment) throws SQLException;
	int delete(int id) throws SQLException;
	List<Comment> selectAll(int notice_id) throws SQLException;
}
