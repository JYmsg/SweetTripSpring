package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.Day;
import com.ssafy.trip.dto.Place;
import com.ssafy.trip.model.repo.DayRepo;
import com.ssafy.trip.model.repo.PlaceRepo;

@Service
public class DayServiceImpl implements DayService {
	@Autowired
	private DayRepo repo;
	@Autowired
	private PlaceRepo Prepo;
	
	@Override
	public int insert(Day day) throws SQLException {
		return repo.insert(day);
	}
	@Override
	public int update(Day day) throws SQLException {
		repo.deleteAttraction(day.getId());
		int r = repo.update(day);
		if(r == 0) return 0;
		for(int p: day.getAttractions()) {
			repo.insertAttraction(day.getId(), p);
		}
		return r;
	}
	@Override
	public int delete(int id) throws SQLException {
		return repo.delete(id);
	}

	@Override
	public Day select(int id) throws SQLException {
		Day day = repo.select(id);
		day.setAttractions(repo.selectAttraction(id));
		for(int p: day.getAttractions()) {
			day.getPlaces().add(Prepo.select(p));
		}
		return day;
	}

	@Override
	public int insertAttraction(int id, int attraction_id) throws SQLException {
		return repo.insertAttraction(id, attraction_id);
	}

	@Override
	public List<Integer> selectAttraction(int id) throws SQLException {
		return repo.selectAttraction(id);
	}

	@Override
	public List<Day> selectAll(int travel_id) throws SQLException {
		List<Day> results = repo.selectAll(travel_id);
		for(Day result: results) {
			System.out.println(result.getId());
			result.setAttractions(repo.selectAttraction(result.getId()));
			if(result.getAttractions() == null || result.getAttractions().size() == 0) continue;
			List<Place> add = new ArrayList<>();
			for(int p: result.getAttractions()) {
				add.add(Prepo.select(p));
			}
			result.setPlaces(add);
		}
		return results;
	}

	@Override
	public int deleteAttraction(int id) throws SQLException {
		return repo.deleteAttraction(id);
	}
}
