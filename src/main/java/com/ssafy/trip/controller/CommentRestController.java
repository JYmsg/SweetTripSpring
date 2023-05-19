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

import com.ssafy.trip.dto.Comment;
import com.ssafy.trip.model.service.CommentService;
import com.ssafy.trip.model.service.CommentService;


@RestController
@CrossOrigin("*")
@RequestMapping("/commentapi")
public class CommentRestController {

	@Autowired
	private CommentService cs;
	
	@PostMapping("/comment")
	public ResponseEntity<?> insert(@RequestBody Comment comment) throws Exception{
		System.out.println(comment);
		int result = cs.insert(comment);
		if(result==1) return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/comment")
	public ResponseEntity<?> update(@RequestBody Comment comment) throws Exception{
		int r = cs.update(comment);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/comment/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws Exception{
		int r = cs.delete(id);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/comment/{notice_id}")
	public ResponseEntity<?> selectAll(@PathVariable int notice_id) throws Exception{
		List<Comment> Comments = cs.selectAll(notice_id);
		System.out.println(Comments);
		if(Comments!=null && Comments.size()>0) return new ResponseEntity<List<Comment>>(Comments, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
}
