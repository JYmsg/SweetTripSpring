package com.ssafy.trip.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.model.service.HotPlaceService;

@Controller
public class IndexController {
	@Autowired
	private HotPlaceService hs;
	
	@GetMapping("/")
	public String index(Model m) throws SQLException {
		List<HotPlace> list = hs.selectAll();
		List<HotPlace> result = new ArrayList<HotPlace>();
		for(HotPlace place : list) {
			if(result.size()>=6) break;
			result.add(place);
		}
		m.addAttribute("hotpls", result);
		return "index";
	}
	
	@GetMapping("/hotplacelist")
	public String hotplacelist() {
		return "hotplace/hotplacelist";
	}
	
	@GetMapping("/hotplacedetail")
	public String hotplacedetail() {
		return "hotpalce/hotplaceview";
	}
	
	@GetMapping("/hotplaceregist")
	public String hotplaceregist() {
		return "hotplace/hotplaceregist";
	}
}
