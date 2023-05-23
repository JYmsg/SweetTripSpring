package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public int insert(Day day) throws SQLException {
		int r = repo.insert(day);
		if(r == 0) { // day 생성 실패.
			return r;
			
		}
		if(day.getPlaces() == null) return r;
		for(int i=0; i<day.getPlaces().size(); i++) {
			Place p = day.getPlaces().get(i);
			repo.insertAttraction(day.getId(), p.getContent_id(), p.getStarttime(), p.getEndtime(), p.getMemo(), i);
		}
		return day.getId();
	}
	@Override
	public int update(Day day) throws SQLException {
//		System.out.println("before = "+repo.selectAttraction(day.getId())+day);
		List<Integer> atts = repo.selectAllAttraction(day.getId());
		if(atts != null) {
			for(int a : atts) {
				if(!day.getPlaces().contains(new Place(a))) {
					repo.deleteoneAttraction(day.getId(), a);
				}
			}
		}
		repo.deleteAttraction(day.getId());
		if(day.getPlaces() != null) {
			for(int i=0; i<day.getPlaces().size(); i++) {
				Place p = day.getPlaces().get(i);
				repo.insertAttraction(day.getId(), p.getContent_id(), p.getStarttime(), p.getEndtime(), p.getMemo(), i);
			}
		}
		int r = repo.update(day);
		if(r == 0) return 0;
		return r;
	}
	@Override
	public int delete(int id) throws SQLException {
		return repo.delete(id);
	}

	@Override
	public Day select(int id) throws SQLException {
		Day day = repo.select(id);
		List<Place> places = repo.selectAttraction(id);
		for(Place p: places) {
			Place any = Prepo.select(p.getContent_id());
			any.setMemo(p.getMemo());
			any.setStarttime(p.getStarttime());
			any.setEndtime(p.getEndtime());
			any.setTurn(p.getTurn());
			day.getPlaces().add(any);
			day.getAttractions().add(p.getContent_id());
		}
		return day;
	}

	@Override
	public int insertAttraction(int id, int attraction_id) throws SQLException {
		return repo.insertAttraction(id, attraction_id, "00:00", "00:00", "", 0);
	}
//
//	@Override
//	public List<Integer> selectAttraction(int id) throws SQLException {
//		return repo.selectAttraction(id);
//	}

	@Override
	public List<Day> selectAll(int travel_id) throws SQLException {
		List<Day> results = repo.selectAll(travel_id);
		System.out.println("day - "+results);
		for(Day result: results) {
			List<Place> places = repo.selectAttraction(result.getId());
			System.out.println(places);
			if(places == null || places.size() == 0) continue;
			result.setPlaces(new ArrayList<Place>());
			result.setAttractions(new ArrayList<Integer>());
			for(Place p: places) {
				Place any = Prepo.select(p.getContent_id());
				if(p.getMemo() != null) any.setMemo(p.getMemo());
				System.out.println("any - "+any);
				any.setStarttime(p.getStarttime());
				any.setEndtime(p.getEndtime());
				any.setTurn(p.getTurn());
				result.getPlaces().add(any);
				result.getAttractions().add(p.getContent_id());
			}
			System.out.println(result);
		}
		return results;
	}

	@Override
	public int deleteAttraction(int id) throws SQLException {
		return repo.deleteAttraction(id);
	}
	@Override
	public List<Integer> selectAttraction(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Place selectoneAttraction(int day_id, int content_id) throws SQLException {
		return repo.selectoneAttraction(day_id, content_id);
	}
}
