package com.ssafy.trip.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.User;
import com.ssafy.trip.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo repo;
	

	@Override
	public User select(String id) throws Exception {
		return repo.select(id);
	}

	@Override
	public int delete(String id) throws Exception {
		return repo.delete(id);
	}

	@Override
	public int insert(User user) throws Exception {
		return repo.insert(user);
	}

	@Override
	public int update(User user) throws Exception {
		return repo.update(user);
	}

}
