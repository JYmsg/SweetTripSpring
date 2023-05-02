package com.ssafy.trip.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.Review;
import com.ssafy.trip.dto.SearchCondition;
import com.ssafy.trip.model.repo.ReviewRepo;
import com.ssafy.trip.util.PageNavigation;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepo repo;
	
	@Override
	public int insert(Review review) throws SQLException {
		return repo.insert(review);
	}

	@Override
	public int update(Review review) throws SQLException {
		return repo.update(review);
	}

	@Override
	public int delete(String writer_id, int travel_id) throws SQLException {
		return repo.delete(writer_id, travel_id);
	}

	@Override
	public Review select(String writer_id, int travel_id) throws SQLException {
		return repo.select(writer_id, travel_id);
	}

	@Override
	public List<Review> selectAll() throws SQLException {
		return repo.selectAll();
	}

	@Override
	public List<Review> search(SearchCondition condition) throws SQLException {
		return repo.search(condition);
	}

	@Override
	public Map<String, Object> pagingSearch(SearchCondition condition) throws SQLException {
		int totalCount = repo.getTotalSearchCount(condition);
		PageNavigation nav = new PageNavigation(condition.getCountPerPage(), totalCount);
		
		Map<String, Object> map = new HashMap<>();
		map.put("books", search(condition));
		System.out.println(search(condition));
		map.put("navigation", nav);
		return map;
	}

}
