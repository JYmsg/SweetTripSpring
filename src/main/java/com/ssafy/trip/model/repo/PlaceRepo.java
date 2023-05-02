package com.ssafy.trip.model.repo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Place;

@Mapper
public interface PlaceRepo {
	List<Place> select(int sidoCode, int gugunCode, int ContentTypeID) throws Exception;
	Place select(int ContentId);
}
