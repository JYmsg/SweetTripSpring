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

import com.ssafy.trip.dto.Review;
import com.ssafy.trip.model.service.ReviewService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/reviewapi")
public class ReviewRestController {

	@Autowired
	private ReviewService rs;
	
	@PostMapping("/review")
	public ResponseEntity<?> insert(@RequestBody Review review) throws Exception{
		int result = rs.insert(review);
		if(result==1) return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/review")
	public ResponseEntity<?> update(@RequestBody Review review) throws Exception{
		int r = rs.update(review);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/review/{writer_id}/{travel_id}")
	public ResponseEntity<?> delete(@PathVariable String writer_id, @PathVariable int travel_id) throws Exception{
		int r = rs.delete(writer_id, travel_id);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/review/{writer_id}/{travel_id}")
	public ResponseEntity<?> select(@PathVariable String writer_id, @PathVariable int travel_id) throws Exception{
		Review review = rs.select(writer_id, travel_id);
		if(review!=null) return new ResponseEntity<Review>(review, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/review")
	public ResponseEntity<?> selectAll() throws Exception{
		List<Review> reviews = rs.selectAll();
		if(reviews!=null && reviews.size()>0) return new ResponseEntity<List<Review>>(reviews, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
}
