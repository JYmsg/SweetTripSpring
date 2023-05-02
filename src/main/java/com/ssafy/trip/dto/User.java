package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	private String id;
	private String password;
	private String name;
	private String salt;
	private String email;
	private String age;
	private String writeArticle;
	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
}
