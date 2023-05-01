package com.ssafy.trip.model.repo;

import java.util.List;

import com.ssafy.trip.dto.Place;

public interface PlaceRepo {
	List<Place> select(int sidoCode, int gugunCode, int ContentTypeID) throws Exception;
}
