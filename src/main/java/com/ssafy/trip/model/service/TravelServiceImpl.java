package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.trip.dto.Day;
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
	public int insert(Travel travel)  throws Exception{
		int id = repo.insert(travel);
		for(User user: travel.getUsers()) {
			repo.invite(travel.getId(), user.getId());
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date start = format.parse(travel.getStartdate());
		Date end = format.parse(travel.getEnddate());
		long diff = (end.getTime()- start.getTime()) / (24*60*60*1000);
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);
		System.out.println(diff);
		svc.insert(new Day(travel.getStartdate(), "맑음", travel.getId()));
		for(int i=0; i<diff; i++) {
			cal.add(Calendar.DATE, 1);
			System.out.println(format.format(cal.getTime()));
			Day add = new Day(format.format(cal.getTime()), "맑음", travel.getId());
			svc.insert(add);
		}
		if(id == 1) return travel.getId();
		return -1;
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
