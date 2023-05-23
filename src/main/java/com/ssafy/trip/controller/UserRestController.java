package com.ssafy.trip.controller;


import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

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
import com.ssafy.trip.util.SHA256Util;

@RestController
@CrossOrigin("*")
@RequestMapping("/userapi")
public class UserRestController {

	@Autowired
	private UserService us;
	
	@PostMapping("/user")
	public ResponseEntity<?> insert(@RequestBody User user) throws SQLException, NoSuchAlgorithmException{
		String salt = SHA256Util.generateSalt();
		String password = SHA256Util.getEncrypt(user.getPassword(), salt);
		user.setSalt(salt);
		user.setPassword(password);
		int result = us.insert(user);
		if(result == 0)
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> update(@RequestBody User user, HttpSession session) throws Exception{
		System.out.println(user);
		User update = (User)session.getAttribute("userinfo");
		int r = us.update(user);
		if(r==1) {
			update.setAge(user.getAge());
			update.setEmail(user.getEmail());
			update.setName(user.getName());
			session.setAttribute("userinfo", update);
			return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		}
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> delete(@PathVariable String id, HttpSession session) throws Exception{
		int r = us.delete(id);
		if(r==1) {
			session.invalidate();
			return new ResponseEntity<Integer>(r, HttpStatus.OK);
		}
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> select(@PathVariable String id) throws Exception{
		User user = us.select(id);
		if(user!=null) return new ResponseEntity<User>(user, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	@GetMapping("/user/keyword/{keyword}")
	public ResponseEntity<?> selectUsers(@PathVariable String keyword) throws Exception{
		System.out.println(keyword);
		List<User> users = us.selectUsers(keyword);
		System.out.println(users);
		if(users!=null) return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) throws Exception{
		User loginUser = us.select(user.getId());
		System.out.println(loginUser);
//		if(loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
//			session.setAttribute("userinfo", loginUser);
//			return new ResponseEntity<User>(loginUser, HttpStatus.OK);
//		}
		String password = SHA256Util.getEncrypt(user.getPassword(), loginUser.getSalt());
		if(loginUser != null && loginUser.getPassword().equals(password)) {
			session.setAttribute("userinfo", loginUser);
			System.out.println("진자");
			return new ResponseEntity<User>(loginUser, HttpStatus.OK);
		}
		System.out.println("가짜");
		return new ResponseEntity<User> (loginUser, HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/mailcheck")
	public ResponseEntity<?> check(@RequestBody User user) throws Exception{
		String code = us.sendMail(user.getEmail());
		if(code!=null) return new ResponseEntity<String>(code, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
}
