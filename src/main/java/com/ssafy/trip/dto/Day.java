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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Day other = (Day) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
