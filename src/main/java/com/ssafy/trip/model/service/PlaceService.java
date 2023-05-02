package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Place;

public interface PlaceService {
	List<Place> selectAll(int sidoCode, int gugunCode, int ContentTypeID) throws SQLException;
	Place select(int ContentId) throws SQLException;
}
