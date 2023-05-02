package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	private String name;
	private String id;
	private String password;
	private String salt;
	private String email;
	private String age;
	private String writeArticle;
}
