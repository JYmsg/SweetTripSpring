package com.ssafy.trip.model.service;

import java.util.ArrayList;

import com.ssafy.trip.dto.Post;


public interface PostService {
	// 전체 게시글 리스트
	ArrayList<Post> getPostList() throws Exception;

	// 게시글 상세 조회
	Post getPost(String id) throws Exception;

	// 게시글 작성
	int setPost(Post post) throws Exception;

	// 게시글 삭제
	int deletePost(String id) throws Exception;

}
