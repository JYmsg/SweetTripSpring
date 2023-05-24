package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import javax.mail.internet.AddressException;

import com.ssafy.trip.dto.User;

public interface UserService {
	User select(String id) throws SQLException;
	int delete(String id) throws SQLException;
	int insert(User user) throws SQLException;
	int update(User user) throws SQLException;
	int updatePassword(User user) throws SQLException;
	List<User> selectAll() throws SQLException;
	List<User> selectInviteAll(int travel_id) throws SQLException;
	List<User> selectUsers(String keyword) throws SQLException;
	
	String makeCode() throws SQLException;
	String sendMail(String email) throws SQLException, AddressException;
}
