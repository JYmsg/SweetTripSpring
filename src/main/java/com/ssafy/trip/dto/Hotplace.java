package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotplace {
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
}
