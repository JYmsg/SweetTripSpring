package com.ssafy.trip.dto;

import org.springframework.web.multipart.MultipartFile;

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
	private int good;
	private String address;
	private String name;
	private int sido;
	private String write_time;
	private String writer_id;
	private MultipartFile file;
	private String orgImg;
	
	public HotPlace(String title, String content, String writer_id, double latitude, double longitude, String img, String address, String name, int sido) {
		this(title, content, writer_id, latitude, longitude, img, address, name, sido, null);
	}
	
	public HotPlace(String title, String content, String writer_id, double latitude, double longitude, String img, String address, String name, int sido, MultipartFile file) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.title = title;
		this.content = content;
		this.img = img;
		this.writer_id = writer_id;
		this.file=file;
		this.sido=sido;
		this.address=address;
		this.name=name;
	}
}
