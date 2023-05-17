package com.ssafy.trip.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SessionInterceptor implements HandlerInterceptor {

	// 컨트롤러 호출 전에 실행되어야 한다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// request 에서 session 정보 얻기
		HttpSession session = request.getSession();
		// 세션에 로그인 정보가 있다면 그대로 진행한다.
		if (session.getAttribute("userinfo") != null) {
			return true;
		}
		// 세션에 로그인 정보가 없다면 redirect 시킨다.
		else {
			log.error("로그인 후 이용해주세요!"+request.getRequestURI());
			response.sendRedirect(request.getContextPath() + "/index");
			return false;
		}
	}
}