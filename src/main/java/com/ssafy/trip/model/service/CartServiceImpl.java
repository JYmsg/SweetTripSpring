package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.Cart;
import com.ssafy.trip.model.repo.CartRepo;
import com.ssafy.trip.model.repo.DayRepo;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepo repo;
	
	@Override
	public int inserthot(Cart cart) throws SQLException {
		return repo.inserthot(cart);
	}

	@Override
	public int insertplace(Cart cart) throws SQLException {
		return repo.inserthot(cart);
	}

	@Override
	public int deletehot(Cart cart) throws SQLException {
		return repo.deletehot(cart);
	}

	@Override
	public int deleteplace(Cart cart) throws SQLException {
		return repo.deleteplace(cart);
	}

	@Override
	public List<Cart> select(String id) throws SQLException {
		System.out.println("in");
		List<Cart> hot = repo.selecthot(id);
		System.out.println("hot"+hot);
		List<Cart> place = repo.selectplace(id);
		System.out.println("place"+place);
		place.addAll(hot);
		return place;
	}

}
