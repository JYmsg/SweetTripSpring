package com.ssafy.trip.model.service;

import java.util.List;

import com.ssafy.trip.dto.Gugun;

public interface GugunService {
	List<Gugun> selectAll(int sido_code) throws Exception;
	String select(int gugun_code, int sido_code) throws Exception;
}
