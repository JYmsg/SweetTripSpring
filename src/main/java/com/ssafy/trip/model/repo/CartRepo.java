package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Cart;

@Mapper
public interface CartRepo {
	int insertplace(Cart cart) throws SQLException;
	int deleteplace(Cart cart) throws SQLException;
	List<Cart> selectAllplace(String id) throws SQLException;
	int selectplace(String user_id, int attraction_id) throws SQLException;
}
