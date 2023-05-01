package com.ssafy.trip.model.repo;

import com.ssafy.trip.dto.User;

public interface UserRepo {
	User select(String id) throws Exception;
	int delete(String id) throws Exception;
	int insert(User user) throws Exception;
	int update(User user) throws Exception;
}