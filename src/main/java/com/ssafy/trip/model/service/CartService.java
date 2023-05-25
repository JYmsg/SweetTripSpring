package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;


import com.ssafy.trip.dto.Cart;

public interface CartService {
	int insertplace(Cart cart) throws SQLException;
	int deleteplace(Cart cart) throws SQLException;
	List<Cart> select(String id) throws SQLException;
	int selectplace(String user_id, int attraction_id) throws SQLException;
}
