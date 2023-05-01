package com.ssafy.trip.model.service;

import java.util.List;

import com.ssafy.trip.dto.Gugun;

public interface GugunService {
	List<Gugun> selectAll(int sidoCode) throws Exception;
	String selete(int gugunCode) throws Exception;
}
