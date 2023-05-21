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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.dto.LikeHotPlace;
import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.model.service.LikeHotPlaceService;
import com.ssafy.trip.model.service.NoticeService;


@RestController
@CrossOrigin("*")
@RequestMapping("/likeapi")
public class LikeHotPlaceRestController {

	@Autowired
	private LikeHotPlaceService ls;
	
	@PostMapping("/likehotpl")
	public ResponseEntity<?> insert(@RequestBody LikeHotPlace likehotpl) throws Exception{
		System.out.println(likehotpl);
		int result = ls.insert(likehotpl);
		if(result==1) return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/likehotpl/{user_id}/{hotplace_id}")
	public ResponseEntity<?> delete(@PathVariable String user_id, @PathVariable int hotplace_id) throws Exception{
		int r = ls.delete(user_id, hotplace_id);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/likehotpl/{user_id}")
	public ResponseEntity<?> select(@PathVariable String user_id) throws Exception{
		System.out.println(user_id);
		List<LikeHotPlace> likes = ls.select(user_id);
		System.out.println(likes);
		if(likes!=null && likes.size()>0) return new ResponseEntity<List<LikeHotPlace>>(likes, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
}
