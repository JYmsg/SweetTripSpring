//package com.ssafy.trip.model.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.ssafy.trip.dto.Place;
//import com.ssafy.trip.model.repo.PlaceRepo;
//
//@Service
//public class PlaceServiceImpl implements PlaceService {
//	
//	private PlaceRepo repo;
//	
//	public PlaceServiceImpl(PlaceRepo repo) {
//		super();
//		this.repo = repo;
//	}
//	@Override
//	public List<Place> select(int sidoCode, int gugunCode, int ContentTypeId) throws Exception {
//		return repo.select(sidoCode, gugunCode, ContentTypeId);
//	}
//
//}
