package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Place;

@Mapper
public interface PlaceRepo {
	List<Place> selectAll(int sidoCode, int gugunCode, int ContentTypeID) throws SQLException;
	List<Place> selectByKeyword(int sidoCode, int gugunCode, int ContentTypeID, String keyword) throws SQLException;
	Place select(int ContentId) throws SQLException;
}
