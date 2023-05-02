package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.Notice;
import com.ssafy.trip.dto.SearchCondition;
import com.ssafy.trip.model.repo.NoticeRepo;
import com.ssafy.trip.util.PageNavigation;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeRepo repo;
	
	
	@Override
	public int insert(Notice notice) throws SQLException {
		return repo.insert(notice);
	}

	@Override
	public int update(Notice notice) throws SQLException {
		return repo.update(notice);
	}

	@Override
	public int delete(int id) throws SQLException {
		return repo.delete(id);
	}

	@Override
	public Notice select(int id) throws SQLException {
		return repo.select(id);
	}

	@Override
	public List<Notice> selectAll() throws SQLException {
		return repo.selectAll();
	}

	@Override
	public List<Notice> search(SearchCondition condition) throws SQLException {
		return repo.search(condition);
	}
	
	@Override
	public Map<String, Object> pagingSearch(SearchCondition condition) throws SQLException {
		int totalCount = repo.getTotalSearchCount(condition);
		PageNavigation nav = new PageNavigation(condition.getCountPerPage(), totalCount);
		
		Map<String, Object> map = new HashMap<>();
		map.put("reviews", search(condition));
		System.out.println(search(condition));
		map.put("navigation", nav);
		return map;
	}
	
	public static void main(String[] args) throws Exception{
		NoticeService sv = new NoticeServiceImpl();
		
		sv.insert(new Notice("test","test-ing","ssafy"));
		
		List<Notice> list = new ArrayList<Notice>();
		list = sv.selectAll();
		for(Notice l : list) System.out.println(l);
	}
}
