package com.ssafy.trip.model.repo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Gugun;

@Mapper
public interface GugunRepo {
	List<Gugun> selectAll(int sidoCode) throws Exception;
	String selete(int gugunCode) throws Exception;
}
