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
	private List<Place> attractions;
}
