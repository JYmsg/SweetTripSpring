package com.ssafy.trip.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Place {
	private int sidoCode;
	private String sido;
	private String gugun;
	private int gugunCode;
	private String title;
	private String address;
	private String zipcode;
	private String img;
	private int contentTypeId;
	private double latitude;
	private double longitude;
}
