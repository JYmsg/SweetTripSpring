package com.ssafy.trip.model.repo;

import java.util.List;

import com.ssafy.trip.dto.Gugun;

public interface GugunRepo {
	List<Gugun> selectAll(int sidoCode) throws Exception;
	String selete(int gugunCode) throws Exception;
}
