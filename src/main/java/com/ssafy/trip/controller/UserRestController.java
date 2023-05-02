package com.ssafy.trip.controller;


import javax.servlet.http.HttpSession;

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

import com.ssafy.trip.dto.User;
import com.ssafy.trip.model.service.UserService;

import SHA256Util.SHA256Util;

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
	
	@PutMapping("/user")
	public ResponseEntity<?> update(@RequestBody User user) throws Exception{
		int r = us.update(user);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) throws Exception{
		int r = us.delete(id);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> select(@PathVariable String id) throws Exception{
		User user = us.select(id);
		if(user!=null) return new ResponseEntity<User>(user, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) throws Exception{
		System.out.println("get = "+user);
		User loginUser = us.select(user.getId());
		System.out.println(loginUser);
		if(loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
			session.setAttribute("userinfo", loginUser);
			return new ResponseEntity<User>(loginUser, HttpStatus.OK);
		}
//		String salt = SHA256Util.generateSalt();
//		String password = SHA256Util.getEncrypt(user.getPassword(), salt);
//		loginUser.getPassword().equals(password);
//		if(loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
//			session.setAttribute("userinfo", loginUser);
//			return new ResponseEntity<User>(loginUser, HttpStatus.OK);
//		}
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
}
