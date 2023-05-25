package com.ssafy.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.model.service.HotPlaceService;
import com.ssafy.trip.model.service.NoticeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/hotplaceapi") 
public class HotPlaceRestController { 

	@Autowired
	private HotPlaceService hs;
	
	@PostMapping("/hotplace")
	public ResponseEntity<?> insert(@ModelAttribute HotPlace hotplace) throws Exception{
		System.out.println(hotplace);
		int result = hs.insert(hotplace);
		if(result==1) return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/hotplace")
	public ResponseEntity<?> update(@RequestBody HotPlace hotplace) throws Exception{
		System.out.println(hotplace);
		int r = hs.update(hotplace);
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
	
	@GetMapping("/hotplace/{id}/{sort}/{find}")
	public ResponseEntity<?> selectAll(@PathVariable int id,@PathVariable String sort, @PathVariable String find) throws Exception{
		System.out.println(sort+" "+find);
		List<HotPlace> hotpls = hs.selectAll(id,sort,find);
		System.out.println(hotpls);
		if(hotpls!=null && hotpls.size()>0) return new ResponseEntity<List<HotPlace>>(hotpls, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/hit")
	public ResponseEntity<?> update_hit(@RequestBody HotPlace hotplace) throws Exception{
		System.out.println(hotplace);
		int r = hs.update_hit(hotplace);
		System.out.println(r);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/good/{id}/{act}")
	public ResponseEntity<?> update_good(@PathVariable int id, @PathVariable int act) throws Exception{
		System.out.println(id+" "+act);
		int r = hs.update_good(id,act);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}
}
