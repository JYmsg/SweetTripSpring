package com.ssafy.trip.model.repo;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.User;

@Mapper
public interface UserRepo {
	User select(String id) throws SQLException;
	int delete(String id) throws SQLException;
	int insert(User user) throws SQLException;
	int update(User user) throws SQLException;
}
