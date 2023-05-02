package com.ssafy.trip.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.Place;

@Mapper
public interface HotPlaceService {
	int insert(HotPlace hotplace, MultipartFile file) throws Exception;
	int update(HotPlace hotplace, MultipartFile file) throws Exception;
	int delete(int id) throws SQLException;
	HotPlace select(int id) throws SQLException;
	List<HotPlace> selectAll() throws SQLException;
}
