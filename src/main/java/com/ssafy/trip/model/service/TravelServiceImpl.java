package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.trip.dto.Travel;
import com.ssafy.trip.dto.User;
import com.ssafy.trip.model.repo.TravelRepo;

@Service
public class TravelServiceImpl implements TravelService {
	@Autowired
	private TravelRepo repo;
	@Autowired
	private DayService svc;
	
	@Override
	@Transactional
	public int insert(Travel travel)  throws SQLException{
		int id = repo.insert(travel);
		for(User user: travel.getUsers()) {
			repo.invite(travel.getId(), user.getId());
		}
		return id;
	}

	@Override
	public int update(Travel travel) throws SQLException {
		return repo.update(travel);
	}

	@Override
	public int delete(int id) throws SQLException {
		return repo.delete(id);
	}

	@Override
	public Travel select(int id) throws SQLException {
		Travel travel = repo.select(id);
		if(travel == null) return null;
		travel.setDays(svc.selectAll(travel.getId()));
		return travel;
	}

	@Override
	public List<Travel> selectAll(String user_id) throws SQLException {
		List<Travel> travels = repo.selectAll(user_id);
		if(travels == null) return null;
		for(Travel travel: travels) {
			travel.setDays(svc.selectAll(travel.getId()));
		}
		return travels;
	}

}
