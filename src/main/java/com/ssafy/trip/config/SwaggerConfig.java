package com.ssafy.trip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// swagger 사용을 위해 선언한다.
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	/**
	 * Swagger를 위한 Docket 빈을 추가한다.
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		final ApiInfo apiInfo = new ApiInfoBuilder()
				.title("EnjoyTrip API")
				.description("<h3>EnjoyTrip에 사용되는 RestApi에 대한 문서를 제공한다.</h3>")
				.contact(new Contact("SSAFY", "https://edu.ssafy.com", "ssafy@ssafy.com"))
				.license("MIT License")
				.version("1.0")
				.build();

		return new Docket(DocumentationType.SWAGGER_2)		// Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) 							// 문서에 대한 정보를 설정한다.
				.select()									// ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.paths(PathSelectors.ant("/**/travelapi/**"))
				.build();									// Docket 객체 생성			
	}
}
