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
	Place selectoverview(int ContentId) throws SQLException;
	List<Place> selectAllPlaces() throws SQLException;
	List<Place> selectAllSido(int sidoCode) throws SQLException;
	List<Place> selectAllSidoGugun(int sidoCode, int gugunCode) throws SQLException;
	List<Place> selectAllSidoType(int sidoCode, int content_type_id) throws SQLException;
}
