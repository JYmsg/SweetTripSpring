package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cart {
	String user_id;
	int hotplace_id;
	int attraction_id;
	User user;
	HotPlace hotplace;
	Place place;
	public Cart(String id, HotPlace hotplace) {
		super();
		this.user_id = id;
		this.hotplace_id = hotplace.getId();
		this.hotplace = hotplace;
	}
	public Cart(String id, Place place) {
		this.user_id = id;
		this.place = place;
		this.attraction_id = place.getContent_id();
	}
}
