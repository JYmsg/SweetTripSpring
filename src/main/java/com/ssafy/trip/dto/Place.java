package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Place {
	private int content_id;
	private int sido_code;
	private String sido;
	private String gugun;
	private int gugun_code;
	private String title;
	private String addr1;
	private String addr2;
	private String zipcode;
	private String first_image;
	private int content_type_id;
	private double latitude;
	private double longitude;
	private boolean in;
	private String overview;
	private String memo;
	private String starttime;
	private String endtime;
	private int turn;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + content_id;
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
		Place other = (Place) obj;
		if (content_id != other.content_id)
			return false;
		return true;
	}
	public Place(int content_id) {
		super();
		this.content_id = content_id;
	}	
}
