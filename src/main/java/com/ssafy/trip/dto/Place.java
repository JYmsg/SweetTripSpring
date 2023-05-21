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
}
