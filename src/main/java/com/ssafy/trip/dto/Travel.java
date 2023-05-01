package com.ssafy.trip.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Travel {
	private int id;
	private String title;
	private String startdate;
	private String enddate;
	private List<String> userId;
	private List<Day> days;
}
