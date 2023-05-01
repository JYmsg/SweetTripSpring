package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
	private int id;
	private String write_id;
	private int travel_id;
	private String title;
	private String content;
	private String img;
	private int hit;
	private String write_time;
	public Post(int id, String write_id, String title, String content, int hit, String write_time) { // notice
		this.id = id;
		this.write_id = write_id;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.write_time = write_time;
	}
	public Post(String write_id, int travel_id, String title, String content, String img, int hit, String write_time) { // Review
		this.write_id = write_id;
		this.travel_id = travel_id;
		this.title = title;
		this.content = content;
		this.img = img;
		this.hit = hit;
		this.write_time = write_time;
	}
}
