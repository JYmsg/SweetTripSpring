package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Cart;

public interface CartService {
	int inserthot(Cart cart) throws SQLException;
	int insertplace(Cart cart) throws SQLException;
	int deletehot(Cart cart) throws SQLException;
	int deleteplace(Cart cart) throws SQLException;
	List<Cart> select(String id) throws SQLException;
}
