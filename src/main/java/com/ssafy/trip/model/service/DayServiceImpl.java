package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.Day;
import com.ssafy.trip.dto.Place;
import com.ssafy.trip.model.repo.DayRepo;
import com.ssafy.trip.model.repo.PlaceRepo;

@Service
public class DayServiceImpl implements DayService {
	private DayRepo repo;
	private PlaceRepo Prepo;
	
	public DayServiceImpl(DayRepo repo, PlaceRepo prepo) {
		this.repo = repo;
		Prepo = prepo;
	}
	@Override
	public void insert(Day day) throws SQLException {
		repo.insert(day);
		for(Place p : day.getAttractions()) {
			repo.insertAttraction(day.getId(), p.getContentId());
		}
	}
	@Override
	public void update(Day day) throws SQLException {
		repo.deleteAttraction(day.getId());
		repo.update(day);
		for(Place p: day.getAttractions()) {
			repo.insertAttraction(day.getId(), p.getContentId());
		}
	}
	@Override
	public int delete(int id) throws SQLException {
		return repo.delete(id);
	}

	@Override
	public Day select(int id) throws SQLException {
		Day day = repo.select(id);
		List<Integer> places = repo.selectAttraction(id);
		for(int p : places) day.getAttractions().add(Prepo.select(p));
		return repo.select(id);
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
			List<Integer> places = repo.selectAttraction(result.getId());
			for(int p : places) result.getAttractions().add(Prepo.select(p));
		}
		return results;
	}

	@Override
	public int deleteAttraction(int id) throws SQLException {
		return repo.deleteAttraction(id);
	}
	public static void main(String[] args) {
		
	}
}
