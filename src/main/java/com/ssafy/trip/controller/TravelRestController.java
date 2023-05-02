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
		int r = ts.insert(travel);
		if(r == 0) return new ResponseEntity<Void>   (HttpStatus.NO_CONTENT); // 204
		
		
		if(r > 0) return new ResponseEntity<Integer>(r, HttpStatus.OK); // 201
		else       return new ResponseEntity<Void>   (HttpStatus.NO_CONTENT); // 204
	}
//	@GetMapping("/cat")
//	public ResponseEntity<?> list() throws SQLException{
//		List<Cat> cats = cs.selectAll();
//		if(cats != null && cats.size() > 0) return new ResponseEntity<List<Cat>>(cats, HttpStatus.OK);
//		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
//	@GetMapping("/cat/{code}")
//	public ResponseEntity<?> select(@PathVariable String code) throws SQLException{
//		Cat c = cs.select(code);
//		if(c != null) return new ResponseEntity<Cat>(c, HttpStatus.OK);
//		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
//	@DeleteMapping("/cat/{code}")
//	public ResponseEntity<?> delete(@PathVariable String code) throws SQLException{
//		int r = cs.delete(code);
//		if(r == 1) return new ResponseEntity<Void>(HttpStatus.OK);
//		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
//	@PutMapping("/cat")
//	public ResponseEntity<?> update(@RequestBody Cat cat) throws SQLException{
//		int r = cs.update(cat);
//		if(r == 1) return new ResponseEntity<Void> (HttpStatus.OK);
//		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
}
