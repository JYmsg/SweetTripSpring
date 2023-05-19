package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.Comment;
import com.ssafy.trip.model.repo.CommentRepo;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo repo;
	
	@Override
	public int insert(Comment comment) throws SQLException {
		return repo.insert(comment);
	}

	@Override
	public int update(Comment comment) throws SQLException {
		return repo.update(comment);
	}

	@Override
	public int delete(int id) throws SQLException {
		return repo.delete(id);
	}

	@Override
	public List<Comment> selectAll(int notice_id) throws SQLException {
		return repo.selectAll(notice_id);
	}

}
