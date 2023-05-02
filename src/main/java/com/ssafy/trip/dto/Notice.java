package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notice {
	private int id;
	private String writer_id;
	private String title;
	private String content;
	private int hit;
	private String write_time;
	
	
	public Notice(String title, String content, String writer_id) {
		super();
		this.writer_id = writer_id;
		this.title = title;
		this.content = content;
	}
}
