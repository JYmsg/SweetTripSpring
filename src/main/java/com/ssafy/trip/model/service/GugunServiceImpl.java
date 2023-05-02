package com.ssafy.trip.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.Gugun;
import com.ssafy.trip.model.repo.GugunRepo;

@Service
public class GugunServiceImpl implements GugunService {
	private GugunRepo repo;
	
	private GugunServiceImpl(GugunRepo repo) {
		this.repo = repo;
	}
	@Override
	public List<Gugun> selectAll(int sido_code) throws Exception {
		return repo.selectAll(sido_code);
	}
	@Override
	public String select(int gugun_code, int sido_code) throws Exception {
		return repo.select(gugun_code, sido_code);
	}

}
