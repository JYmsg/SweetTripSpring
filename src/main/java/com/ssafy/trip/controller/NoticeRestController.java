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

import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.model.service.NoticeService;


@RestController
@CrossOrigin("*")
@RequestMapping("/noticeapi")
public class NoticeRestController {

	@Autowired
	private NoticeService ns;
	
	@PostMapping("/notice")
	public ResponseEntity<?> insert(@RequestBody Notice notice) throws Exception{
		int result = ns.insert(notice);
		if(result==1) return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/notice")
	public ResponseEntity<?> update(@RequestBody Notice notice) throws Exception{
		int r = ns.update(notice);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/notice/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws Exception{
		int r = ns.delete(id);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/notice/{id}")
	public ResponseEntity<?> select(@PathVariable int id) throws Exception{
		Notice notice = ns.select(id);
		if(notice!=null) return new ResponseEntity<Notice>(notice, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/notice")
	public ResponseEntity<?> selectAll() throws Exception{
		List<Notice> notices = ns.selectAll();
		if(notices!=null && notices.size()>0) return new ResponseEntity<List<Notice>>(notices, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
}
