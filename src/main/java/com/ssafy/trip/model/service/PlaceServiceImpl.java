package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.Place;
import com.ssafy.trip.model.repo.CartRepo;
import com.ssafy.trip.model.repo.PlaceRepo;

@Service
public class PlaceServiceImpl implements PlaceService {
	@Autowired
	private PlaceRepo repo;
	@Autowired
	private CartService csv;
	
	@Override
	public List<Place> selectAll(int sidoCode, int gugunCode, int ContentTypeID) throws SQLException {
		return repo.selectAll(sidoCode, gugunCode, ContentTypeID);
	}
	
	@Override
	public List<Place> selectByKeyword(int sidoCode, int gugunCode, int ContentTypeID, String keyword, String id) throws SQLException {
		List<Place> places = repo.selectByKeyword(sidoCode, gugunCode, ContentTypeID, keyword);
		for(int i=0; i<places.size(); i++) {
			if(csv.selectplace(id, places.get(i).getContent_id()) > 0) places.get(i).setIn(true);
		}
		System.out.println("places" + places);
		return places;
	}

	@Override
	public Place select(int ContentId) throws SQLException {
		return repo.select(ContentId);
	}

	@Override
	public List<Place> selectAlluser(int sidoCode, int gugunCode, int ContentTypeID, String user_id)
			throws SQLException {
//		List<Place> places = selectAll(sidoCode, gugunCode, ContentTypeID);
//		for(int i=0; i<places.size(); i++) {
//			if(crepo.selectplace(user_id, places.get(i).getContent_id()) > 0) places.get(i).setIn(true);
//		}
		return null;
	}

	@Override
	public List<Place> selectAllPlaces() throws SQLException {
		return repo.selectAllPlaces();
	}

	@Override
	public List<Place> selectAllSido(int sidoCode) throws SQLException {
		return repo.selectAllSido(sidoCode);
	}

	@Override
	public List<Place> selectAllSidoGugun(int sidoCode, int gugunCode) throws SQLException {
		return repo.selectAllSidoGugun(sidoCode, gugunCode);
	}

	@Override
	public List<Place> selectAllSidoType(int sidoCode, int content_type_id) throws SQLException {
		return repo.selectAllSidoType(sidoCode, content_type_id);
	}

	@Override
	public Place selectoverview(int ContentId) throws SQLException {
		return repo.selectoverview(ContentId);
	}
}
