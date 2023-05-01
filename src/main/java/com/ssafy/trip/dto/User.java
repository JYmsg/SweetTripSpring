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
	private String emailname;
	private String domain;
}
