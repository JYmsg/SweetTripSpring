package com.ssafy.trip.model.repo;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.dto.Post;

@Mapper
public interface PostRepo {
	// 전체 게시글 리스트
	ArrayList<Post> getPostList() throws Exception;

	// 게시글 상세 조회
	Post getPost(String id) throws Exception;

	// 게시글 작성
	int setPost(Post post) throws Exception;

	// 게시글 삭제
	int deletePost(String id) throws Exception;

}
