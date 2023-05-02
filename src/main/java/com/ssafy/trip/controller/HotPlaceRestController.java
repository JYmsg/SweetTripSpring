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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.Review;
import com.ssafy.trip.model.service.HotPlaceService;
import com.ssafy.trip.model.service.NoticeService;
import com.ssafy.trip.model.service.ReviewService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/hotplaceapi")
public class HotPlaceRestController {

	@Autowired
	private HotPlaceService hs;
	
	@PostMapping("/hotplace")
	public ResponseEntity<?> insert(@RequestBody HotPlace hotplace, @RequestPart(required = false) MultipartFile file) throws Exception{
		int result = hs.insert(hotplace,file);
		if(result==1) return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/hotplace")
	public ResponseEntity<?> update(@RequestBody HotPlace hotplace, @RequestPart(required = false) MultipartFile file) throws Exception{
		int r = hs.update(hotplace,file);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/hotplace/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws Exception{
		int r = hs.delete(id);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/hotplace/{id}")
	public ResponseEntity<?> select(@PathVariable int id) throws Exception{
		HotPlace hotplace = hs.select(id);
		if(hotplace!=null) return new ResponseEntity<HotPlace>(hotplace, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/hotplace")
	public ResponseEntity<?> selectAll() throws Exception{
		List<HotPlace> hotpls = hs.selectAll();
		if(hotpls!=null && hotpls.size()>0) return new ResponseEntity<List<HotPlace>>(hotpls, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
}
