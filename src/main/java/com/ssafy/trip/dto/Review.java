package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {
	private String writer_id;
	private int travel_id;
	private String title;
	private String content;
	private String img;
	private int hit;
	private String write_time;
}
