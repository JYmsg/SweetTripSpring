package com.ssafy.trip.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.dto.Place;
import com.ssafy.trip.dto.SearchCondition;

@Mapper
public interface HotPlaceRepo {
	int insert(HotPlace hotplace) throws SQLException;
	int update(HotPlace hotplace) throws SQLException;
	int delete(int id) throws SQLException;
	HotPlace select(int id) throws SQLException;
	List<HotPlace> selectAll(int id, String sort, String find) throws SQLException;
	
	int update_hit(HotPlace hotplace) throws SQLException;
	int update_good(int id, int act) throws SQLException;
	
//	List<HotPlace> search(SearchCondition condition) throws SQLException;
}
