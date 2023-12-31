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
import com.ssafy.trip.model.service.DayService;
import com.ssafy.trip.model.service.PlaceService;

@CrossOrigin("*")
@RestController
@RequestMapping("/placeapi")
public class PlaceRestController {
	@Autowired
	private PlaceService ps;
	@Autowired
	private DayService ds;
	
	@GetMapping("/place/one/{content_id}")
	public ResponseEntity<?> selectAllTravel(@PathVariable int content_id) throws SQLException{
		System.out.println(content_id);
		Place place = ps.selectoverview(content_id);
		if(place != null) return new ResponseEntity<Place> (place, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/place/one/{day_id}/{content_id}")
	public ResponseEntity<?> selectPlace(@PathVariable int day_id, @PathVariable int content_id) throws SQLException{
		System.out.println(content_id);
		Place place = ps.selectoverview(content_id);
		Place memo = ds.selectoneAttraction(day_id, content_id);
		if(place == null) return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		place.setMemo(memo.getMemo());
		place.setEndtime(memo.getEndtime());
		place.setStarttime(memo.getStarttime());
		return new ResponseEntity<Place> (place, HttpStatus.OK);
	}
	@GetMapping("/place/list/{sido_code}/{gugun_code}/{contentTypeId}")
	public ResponseEntity<?> selectAllDay(@PathVariable int sido_code, @PathVariable int gugun_code, @PathVariable int contentTypeId) throws Exception{
		System.out.println("sido =" + sido_code);
		List<Place> places = ps.selectAll(sido_code, gugun_code, contentTypeId);
		System.out.println("get = " + places);
		if(places != null && places.size() > 0) return new ResponseEntity<List<Place>> (places, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
//	@PostMapping("/place/list")
//	public ResponseEntity<?> selectAllPlace(@RequestBody Map<String, String> map) throws Exception{
//		System.out.println(map);
//		List<Place> places = ps.selectByKeyword(Integer.parseInt(map.get("sido_code")), Integer.parseInt(map.get("gugun_code")), Integer.parseInt(map.get("contentTypeId")), map.get("keyword"));
//		System.out.println(places);
//		if(places != null) return new ResponseEntity<List<Place>> (places, HttpStatus.OK);
//		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
	@GetMapping("/place/list")
	public ResponseEntity<?> selectAll() throws Exception{
		List<Place> places = ps.selectAllPlaces();
		System.out.println(places);
		if(places != null && places.size() > 0) return new ResponseEntity<List<Place>> (places, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/place/list/sido/{sido_code}")
	public ResponseEntity<?> selectAllSido(@PathVariable int sido_code) throws Exception{
		List<Place> places = ps.selectAllSido(sido_code);
		System.out.println(places);
		if(places != null && places.size() > 0) return new ResponseEntity<List<Place>> (places, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/place/list/sido/{sido_code}/{gugun_code}")
	public ResponseEntity<?> selectAllSidoGugun(@PathVariable int sido_code, @PathVariable int gugun_code) throws Exception{
		List<Place> places = ps.selectAllSidoGugun(sido_code, gugun_code);
		System.out.println(places);
		if(places != null && places.size() > 0) return new ResponseEntity<List<Place>> (places, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/place/list/{sido_code}/{content_type_id}")
	public ResponseEntity<?> selectAllSidoType(@PathVariable int sido_code, @PathVariable int content_type_id) throws Exception{
		List<Place> places = ps.selectAllSidoType(sido_code, content_type_id);
		System.out.println(places);
		if(places != null && places.size() > 0) return new ResponseEntity<List<Place>> (places, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PostMapping("/place/list/{id}")
	public ResponseEntity<?> selectAllPlaceUser(@RequestBody Map<String, String> map, @PathVariable String id) throws Exception{
		System.out.println(map);
		List<Place> places = ps.selectByKeyword(Integer.parseInt(map.get("sido_code")), Integer.parseInt(map.get("gugun_code")), Integer.parseInt(map.get("contentTypeId")), map.get("keyword"), id);
		System.out.println(places);
		if(places != null) return new ResponseEntity<List<Place>> (places, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
