package com.ssafy.trip.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.dto.Day;
import com.ssafy.trip.dto.Travel;
import com.ssafy.trip.model.service.DayService;
import com.ssafy.trip.model.service.TravelService;


@CrossOrigin("*")
@RestController
@RequestMapping("/travelapi")
public class TravelRestController {
	@Autowired
	private TravelService ts;
	
	@Autowired
	private DayService ds;
	
	
	@PostMapping("/travel")
	public ResponseEntity<?> insert(@RequestBody Travel travel) throws SQLException{
		System.out.println(travel);
		int r = ts.insert(travel);
		if(r > 0) return new ResponseEntity<Integer>(r, HttpStatus.CREATED); // 201
		else       return new ResponseEntity<Void>   (HttpStatus.NO_CONTENT); // 204
	}
	@PostMapping("/day")
	public ResponseEntity<?> insert(@RequestBody Day day) throws SQLException{
		int r = ds.insert(day);
		if(r == 0) return new ResponseEntity<Void>   (HttpStatus.NO_CONTENT); // 204
		return new ResponseEntity<Integer>(r, HttpStatus.CREATED); // 201
	}
	@PutMapping("/travel")
	public ResponseEntity<?> update(@RequestBody Travel travel) throws SQLException{
		int r = ts.update(travel);
		if(r == 1) return new ResponseEntity<Void> (HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/day")
	public ResponseEntity<?> update(@RequestBody Day day) throws SQLException{
		int r = ds.update(day);
		if(r == 1) return new ResponseEntity<Void> (HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@DeleteMapping("/travel/{travel_id}")
	public ResponseEntity<?> deleteTravel(@PathVariable int travel_id) throws SQLException{
		int r = ts.delete(travel_id);
		if(r == 1) return new ResponseEntity<Integer> (r, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@DeleteMapping("/day/{day_id}")
	public ResponseEntity<?> deleteDay(@PathVariable int day_id) throws SQLException{
		int r = ds.delete(day_id);
		if(r == 1) return new ResponseEntity<Integer> (r, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/travel/one/{travel_id}")
	public ResponseEntity<?> selectTravel(@PathVariable int travel_id) throws SQLException{
		Travel travel = ts.select(travel_id);
		if(travel != null) return new ResponseEntity<Travel> (travel, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/day/one/{day_id}")
	public ResponseEntity<?> selectDay(@PathVariable int day_id) throws SQLException{
		Day day = ds.select(day_id);
		if(day != null) return new ResponseEntity<Day> (day, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/travel/list/{user_id}")
	public ResponseEntity<?> selectAllTravel(@PathVariable String user_id) throws SQLException{
		System.out.println(user_id);
		List<Travel> travels = ts.selectAll(user_id);
		if(travels != null && travels.size() > 0) return new ResponseEntity<List<Travel>> (travels, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/day/list/{travel_id}")
	public ResponseEntity<?> selectAllDay(@PathVariable int travel_id) throws SQLException{
		List<Day> days = ds.selectAll(travel_id);
		if(days != null && days.size() > 0) return new ResponseEntity<List<Day>> (days, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
}
