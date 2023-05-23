package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.User;
import com.ssafy.trip.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo repo;
	

	@Override
	public User select(String id) throws SQLException {
		return repo.select(id);
	}

	@Override
	public int delete(String id) throws SQLException {
		return repo.delete(id);
	}

	@Override
	public int insert(User user) throws SQLException {
		System.out.println(user);
		return repo.insert(user);
	}

	@Override
	public int update(User user) throws SQLException {
		return repo.update(user);
	}

	@Override
	public List<User> selectAll() throws SQLException {
		return repo.selectAll();
	}

	@Override
	public List<User> selectUsers(String keyword) throws SQLException {
		return repo.selectUsers(keyword);
	}

	@Override
	public List<User> selectInviteAll(int travel_id) throws SQLException {
		return repo.selectInviteAll(travel_id);
	}

}
