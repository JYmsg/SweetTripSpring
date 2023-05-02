package com.ssafy.trip.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Day {
	private int id;
	private String date;
	private String weather;
	private int travel_id;
	private List<Integer> attractions;
	private List<Place> places;
	public Day(String date, String weather, int travel_id) {
		super();
		this.date = date;
		this.weather = weather;
		this.travel_id = travel_id;
	}
}
