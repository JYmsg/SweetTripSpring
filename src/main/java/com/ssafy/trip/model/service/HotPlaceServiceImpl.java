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
	public int insert(HotPlace hotplace, MultipartFile file) throws Exception {
		fileHandling(hotplace, file);
		return repo.insert(hotplace);
	}

	@Override
	@Transactional
	public int update(HotPlace hotplace, MultipartFile file) throws Exception {
		fileHandling(hotplace, file);
		return repo.update(hotplace);
	}

	private void fileHandling(HotPlace hotplace, MultipartFile file) throws IllegalStateException, IOException {
		// 파일을 저장할 폴더 지정
		Resource res = resLoader.getResource("classpath:/static/resources/upload");
		log.debug("res: {}", res.getFile().getCanonicalPath());
		if (file != null && file.getSize() > 0) {
			hotplace.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + hotplace.getImg()));
		}
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
	public List<HotPlace> selectAll() throws SQLException {
		return repo.selectAll();
	}
}
