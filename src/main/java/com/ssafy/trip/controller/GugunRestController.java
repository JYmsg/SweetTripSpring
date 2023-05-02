package com.ssafy.trip.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.dto.User;
import com.ssafy.trip.dto.Gugun;
import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.Review;
import com.ssafy.trip.model.service.GugunService;
import com.ssafy.trip.model.service.NoticeService;
import com.ssafy.trip.model.service.ReviewService;
import com.ssafy.trip.model.service.UserService;

import SHA256Util.SHA256Util;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/gugunapi")
public class GugunRestController {

	@Autowired
	private GugunService gs;
	
	@GetMapping("/gugun/{sido_code}")
	public ResponseEntity<?> selectAll(@PathVariable int sido_code) throws Exception{
		List<Gugun> guguns = gs.selectAll(sido_code);
		if(guguns!=null && guguns.size()>0) return new ResponseEntity<List<Gugun>>(guguns, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}

	@GetMapping("/gugun/{sido_code}/{gugun_code}")
	public ResponseEntity<?> select(@PathVariable int gugun_code, @PathVariable int sido_code) throws Exception{
		String gugun = gs.select(gugun_code, sido_code);
		if(gugun!=null) return new ResponseEntity<String>(gugun, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
}
