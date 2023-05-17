package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.Place;
import com.ssafy.trip.model.repo.PlaceRepo;

@Service
public class PlaceServiceImpl implements PlaceService {
	@Autowired
	private PlaceRepo repo;

	@Override
	public List<Place> selectAll(int sidoCode, int gugunCode, int ContentTypeID) throws SQLException {
		return repo.selectAll(sidoCode, gugunCode, ContentTypeID);
	}
	
	@Override
	public List<Place> selectByKeyword(int sidoCode, int gugunCode, int ContentTypeID, String keyword) throws SQLException {
		return repo.selectByKeyword(sidoCode, gugunCode, ContentTypeID, keyword);
	}

	@Override
	public Place select(int ContentId) throws SQLException {
		return repo.select(ContentId);
	}
}
