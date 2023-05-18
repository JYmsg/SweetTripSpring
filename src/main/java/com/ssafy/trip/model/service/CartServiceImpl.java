package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.Cart;
import com.ssafy.trip.dto.Place;
import com.ssafy.trip.model.repo.CartRepo;
import com.ssafy.trip.model.repo.DayRepo;
import com.ssafy.trip.model.repo.PlaceRepo;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepo repo;
	@Autowired
	private PlaceRepo srepo;
	
	@Override
	public int inserthot(Cart cart) throws SQLException {
		return repo.inserthot(cart);
	}

	@Override
	public int insertplace(Cart cart) throws SQLException {
		return repo.insertplace(cart);
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
		List<Cart> hot = repo.selecthot(id);
		List<Cart> place = repo.selectAllplace(id);
		for(int i=0; i<place.size(); i++) {
			Place p = srepo.select(place.get(i).getAttraction_id());
			System.out.println(p);
			place.get(i).setPlace(p);
		}
		place.addAll(hot);
		return place;
	}

	@Override
	public int selectplace(String user_id, int attraction_id) throws SQLException {
		return repo.selectplace(user_id, attraction_id);
	}

}