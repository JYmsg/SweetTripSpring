package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
	String id; // UUID로 고유값 생성
	String title;
	String content;
	String author;
}
