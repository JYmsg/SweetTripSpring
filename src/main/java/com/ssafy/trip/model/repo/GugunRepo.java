package com.ssafy.trip.model.repo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Gugun;

@Mapper
public interface GugunRepo {
	List<Gugun> selectAll(int sido_code) throws Exception;
	String select(int gugun_code, int sido_code) throws Exception;
}
