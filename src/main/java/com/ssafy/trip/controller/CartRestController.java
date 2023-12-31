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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.dto.Cart;
import com.ssafy.trip.model.service.CartService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cartapi")
public class CartRestController {
	@Autowired
	private CartService cs;
	
	@GetMapping("/cart/list/{user_id}")
	public ResponseEntity<?> selectAll(@PathVariable String user_id) throws Exception{
		List<Cart> carts = cs.select(user_id);
		System.out.println("mycart = "+carts);
		if(carts != null) return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PostMapping("/cart/place")
	public ResponseEntity<?> insertatt(@RequestBody Cart cart) throws Exception{
		System.out.println("place " + cart);
		int r = cs.insertplace(cart);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@DeleteMapping("/cart/place")
	public ResponseEntity<?> deleteatt(@RequestBody Cart cart) throws Exception{
		System.out.println(cart);
		int r = cs.deleteplace(cart);
		if(r==1) return new ResponseEntity<Integer>(r, HttpStatus.CREATED);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
