package com.ssafy.trip.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.trip.dto.HotPlace;
import com.ssafy.trip.dto.SearchCondition;
import com.ssafy.trip.model.repo.HotPlaceRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HotPlaceServiceImpl implements HotPlaceService {
	
	@Autowired
	private HotPlaceRepo repo;
	
	@Autowired
	ResourceLoader resLoader;
	
	@Override
	@Transactional
	public int insert(HotPlace hotplace) throws Exception {
		MultipartFile file = hotplace.getFile();
		if (file != null && file.getSize() > 0) {
			// 파일을 저장할 위치 지정
//			Resource res = resLoader.getResource("classpath:static/resources/upload");
			
			String uploadFolder = "C:/SSAFY/work_pjt/SweetTripVue/public/img/upload";
			// 중복방지를 위해 파일 이름앞에 현재 시간 추가
			hotplace.setOrgImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			// 파일 저장
			file.transferTo(new File(uploadFolder, hotplace.getOrgImg()));
//			file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + hotplace.getOrgImg()));
//			hotplace.setImg(res.getFile().getCanonicalPath() + "/" + hotplace.getOrgImg());
			hotplace.setImg(hotplace.getOrgImg());
		}
		return repo.insert(hotplace);
	}

	@Override
	@Transactional
	public int update(HotPlace hotplace) throws Exception {
		MultipartFile file = hotplace.getFile();
		if (file != null && file.getSize() > 0) {
			// 파일을 저장할 위치 지정
			Resource res = resLoader.getResource("classpath:static/resources/upload");
			// 중복방지를 위해 파일 이름앞에 현재 시간 추가
			hotplace.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			hotplace.setOrgImg(file.getOriginalFilename());
			// 파일 저장
			file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + hotplace.getImg()));
		}
		return repo.update(hotplace);
	}
	
	@Override
	@Transactional
	public int delete(int id) throws SQLException {
		return repo.delete(id);
	}

	@Override
	public HotPlace select(int id) throws SQLException {
		return repo.select(id);
	}

	@Override
	public List<HotPlace> selectAll(int id, String sort, String find) throws SQLException {
		return repo.selectAll(id,sort,find);
	}

	@Override
	public int update_hit(HotPlace hotplace) throws SQLException {
		return repo.update_hit(hotplace);
	}

	@Override
	public int update_good(int id, int act) throws SQLException {
		return repo.update_good(id, act);
	}

//	@Override
//	public List<HotPlace> search(SearchCondition condition) throws SQLException {
//		return repo.search(condition);
//	}
}
