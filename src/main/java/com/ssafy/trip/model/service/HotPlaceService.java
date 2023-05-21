package com.ssafy.trip.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.dto.Place;
import com.ssafy.trip.dto.SearchCondition;

public interface HotPlaceService {
	int insert(HotPlace hotplace) throws Exception;
	int update(HotPlace hotplace) throws Exception;
	int delete(int id) throws SQLException;
	HotPlace select(int id) throws SQLException;
	List<HotPlace> selectAll(int id,String sort, String find) throws SQLException;
	
	int update_hit(HotPlace hotplace) throws SQLException;
	int update_good(int id, int act) throws SQLException;
	
//	List<HotPlace> search(SearchCondition condition) throws SQLException;
}
