package com.ssafy.trip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@("com.ssafy.trip.model.repo")
public class TripBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripBootApplication.class, args);
	}

}
