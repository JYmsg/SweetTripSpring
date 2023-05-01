package com.ssafy.trip.model.service;

import java.util.ArrayList;

import com.ssafy.trip.dto.Post;
import com.ssafy.trip.model.repo.PostRepo;


public class PostServiceImpl implements PostService {


	private PostRepo repo;
	
	public PostServiceImpl(PostRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public ArrayList<Post> getPostList() throws Exception {
		return repo.getPostList();
	}

	@Override
	public Post getPost(String id) throws Exception {
		return repo.getPost(id);
	}

	@Override
	public int setPost(Post post) throws Exception {
		return repo.setPost(post);
	}

	@Override
	public int deletePost(String id) throws Exception {
		return repo.deletePost(id);
	}

}
