package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Cart;

@Mapper
public interface CartRepo {
	int inserthot(Cart cart) throws SQLException;
	int insertplace(Cart cart) throws SQLException;
	int deletehot(Cart cart) throws SQLException;
	int deleteplace(Cart cart) throws SQLException;
	List<Cart> selecthot(String id) throws SQLException;
	List<Cart> selectplace(String id) throws SQLException;
}
