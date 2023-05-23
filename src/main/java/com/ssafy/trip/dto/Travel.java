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
	private String user_id;
	private List<User> users;
	private List<Day> days;
	private int save; // 저장 유무를 표현(0- 임시저장, 1-등록완료)
	private int reveal;
	public Travel(String title, String startdate, String enddate, String user_id) {
		super();
		this.title = title;
		this.startdate = startdate;
		this.enddate = enddate;
		this.user_id = user_id;
	}
}
