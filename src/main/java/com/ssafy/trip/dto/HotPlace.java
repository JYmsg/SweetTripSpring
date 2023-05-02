package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotPlace {
	private int id;
	private double latitude;
	private double longitude;
	private String title;
	private String content;
	private String img;
	private int hit;
	private int like;
	private String write_time;
	private String writer_id;
	
	
	public HotPlace(String title, String content, String writer_id, double latitude, double longitude, String img) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.title = title;
		this.content = content;
		this.img = img;
		this.writer_id = writer_id;
	}
}
