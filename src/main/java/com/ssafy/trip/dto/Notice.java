package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notice {
	private int id;
	private String write_id;
	private String title;
	private String content;
	private int hit;
	private String write_time;
	
	
	public Notice(String title, String content, String write_id) {
		super();
		this.write_id = write_id;
		this.title = title;
		this.content = content;
	}
}
