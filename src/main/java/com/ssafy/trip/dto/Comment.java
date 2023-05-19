package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
	private int id;
	private String content;
	private int pr;
	private String writer_id;
	private String notice_id;
	
	
	public Comment(String content, int pr, String notice_id, String writer_id) {
		super();
		this.content = content;
		this.pr=pr;
		this.notice_id = notice_id;
		this.writer_id = writer_id;
	}
}
