package com.ssafy.trip.model.service;

import java.util.List;

import com.ssafy.trip.dto.Place;


public interface PlaceService {
	List<Place> select(int sidoCode, int gugunCode, int ContentTypeID) throws Exception;
}
