package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.trip.dto.Place;

public interface PlaceService {
	List<Place> selectAll(int sidoCode, int gugunCode, int ContentTypeID) throws SQLException;
	List<Place> selectByKeyword(int sidoCode, int gugunCode, int ContentTypeID, String keyword) throws SQLException;
	Place select(int ContentId) throws SQLException;
}
