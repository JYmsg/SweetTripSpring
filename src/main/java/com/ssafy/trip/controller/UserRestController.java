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
import com.ssafy.trip.dto.Review;
import com.ssafy.trip.model.service.NoticeService;
import com.ssafy.trip.model.service.ReviewService;
import com.ssafy.trip.model.service.UserService;

import SHA256Util.SHA256Util;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/userapi")
public class UserRestController {

	@Autowired
	private UserService us;
	
	@PostMapping("/user")
	public ResponseEntity<?> insert(@RequestBody User user) throws Exception{
		String salt = SHA256Util.generateSalt();
		String password = SHA256Util.getEncrypt(user.getPassword(), salt);
		user.setSalt(salt);
		user.setPassword(password);
		int result = us.insert(user);
		if(result==1) return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/User")
	public ResponseEntity<?> update(@RequestBody User user) throws Exception{
		int r = us.update(user);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/User/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) throws Exception{
		int r = us.delete(id);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/User/{id}")
	public ResponseEntity<?> select(@PathVariable String id) throws Exception{
		User user = us.select(id);
		if(user!=null) return new ResponseEntity<User>(user, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
}
