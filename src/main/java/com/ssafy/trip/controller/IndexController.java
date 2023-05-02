package com.ssafy.trip.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.model.service.HotPlaceService;
import com.ssafy.trip.model.service.NoticeService;

@Controller
public class IndexController {
	@Autowired
	private HotPlaceService hs;
	@Autowired
	private NoticeService ns;
	
	@GetMapping({"/","/index"})
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
	public String hotplacelist(Model m) throws SQLException {
		m.addAttribute("hotpls", hs.selectAll());
		return "hotplace/hotplacelist";
	}
	
	@PostMapping("/hotplacelist")
	public String hotplacelist(HotPlace hotplace, @RequestPart(required = false) MultipartFile file, Model m) throws SQLException {
		try {
			hotplace.setLatitude(1.1);
			hotplace.setLongitude(1.1);
			hotplace.setWriter_id("ssafy");
			hs.insert(hotplace, file);
			m.addAttribute("msg", "등록되었습니다.");
		} catch (Exception e) {
			m.addAttribute("err","등록 중 오류가 발생했습니다..");
			e.printStackTrace();
		}
		return "redirect:/hotplacelist";
	}
	
	@GetMapping("/hotplacedetail")
	public String hotplacedetail(int id, Model m) throws SQLException {
		m.addAttribute("hotpl", hs.select(id));
		System.out.println(hs.select(id));
		return "hotplace/hotplacedetail";
	}
	
	@GetMapping("/hotplaceregist")
	public String hotplaceregist() {
		return "hotplace/hotplaceregist";
	}
	
	@GetMapping("/hotpldel")
	public String hotpldelete(int id) throws SQLException {
		hs.delete(id);
		return "redirect:/hotplacelist";
	}
	
	@GetMapping("/noticelist")
	public String noticelist(Model m) throws SQLException {
		m.addAttribute("notices", ns.selectAll());
		return "board/noticelist";
	}
	
	@PostMapping("/noticelist")
	public String noticelist(Notice notice, Model m) {
		try {
			notice.setWriter_id("ssafy");
			ns.insert(notice);
			m.addAttribute("msg", "등록되었습니다.");
		} catch (Exception e) {
			m.addAttribute("err","등록 중 오류가 발생했습니다..");
			e.printStackTrace();
		}
		return "redirect:/noticelist";
	}
	
	@GetMapping("/noticeview")
	public String noticeview(int id, Model m) throws SQLException {
		m.addAttribute("notice", ns.select(id));
		System.out.println(ns.select(id));
		return "board/noticeview";
	}
	
	@GetMapping("/noticedel")
	public String noticedel(int id) throws SQLException {
		ns.delete(id);
		return "redirect:/noticelist";
	}
	
	@GetMapping("/noticeupdate")
	public String noticeupdate(int id, Model m) throws SQLException {
		m.addAttribute("notice", ns.select(id));
		return "board/noticeupdate";
	}
	
	@PostMapping("/noticeupdate")
	public String noticeupdate(Notice notice, Model m) {
		try {
			ns.update(notice);
			m.addAttribute("msg", "등록되었습니다.");
		} catch (Exception e) {
			m.addAttribute("err","등록 중 오류가 발생했습니다..");
			e.printStackTrace();
		}
		return "redirect:/noticelist";
	}
	
	@GetMapping("/noticewrite")
	public String noticewrite() throws SQLException{
		return "board/noticewrite";
	}
	
	
	@GetMapping("/searchPlace")
	public String searchPlace() {
		return "maketrip/searchPlace";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/mypage")
	public String mypage() {
		return "user/mypage";
	}
	
	
}
