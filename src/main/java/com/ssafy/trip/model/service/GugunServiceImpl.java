package com.ssafy.trip.model.service;

import java.util.List;


import com.ssafy.trip.dto.Gugun;
import com.ssafy.trip.model.repo.GugunRepo;

public class GugunServiceImpl implements GugunService {
	private GugunRepo repo;
	
	private GugunServiceImpl(GugunRepo repo) {
		this.repo = repo;
	}
	@Override
	public List<Gugun> selectAll(int sidoCode) throws Exception {
		return repo.selectAll(sidoCode);
	}
	@Override
	public String selete(int gugunCode) throws Exception {
		return repo.selete(gugunCode);
	}

}
