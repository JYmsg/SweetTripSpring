package com.ssafy.trip.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.dto.Place;
import com.ssafy.trip.model.service.PlaceService;

@CrossOrigin("*")
@RestController
@RequestMapping("/placeapi")
public class PlaceRestController {
	@Autowired
	private PlaceService ps;
	
	@GetMapping("/place/one/{content_id}")
	public ResponseEntity<?> selectAllTravel(@PathVariable int content_id) throws SQLException{
		Place place = ps.select(content_id);
		if(place != null) return new ResponseEntity<Place> (place, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/place/list/{sido_code}/{gugun_code}/{contentTypeId}")
	public ResponseEntity<?> selectAllDay(@PathVariable int sido_code, @PathVariable int gugun_code, @PathVariable int contentTypeId) throws Exception{
		System.out.println("sido =" + sido_code);
		List<Place> places = ps.selectAll(sido_code, gugun_code, contentTypeId);
		System.out.println("get = " + places);
		if(places != null && places.size() > 0) return new ResponseEntity<List<Place>> (places, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PostMapping("/place/list")
	public ResponseEntity<?> selectAllPlace(@RequestBody Map<String, String> map) throws Exception{
		List<Place> places = ps.selectByKeyword(Integer.parseInt(map.get("sido_code")), Integer.parseInt(map.get("gugun_code")), Integer.parseInt(map.get("contentTypeId")), map.get("keyword"));
		System.out.println(places);
		if(places != null && places.size() > 0) return new ResponseEntity<List<Place>> (places, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
