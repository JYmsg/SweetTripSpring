package com.ssafy.trip.controller;
//package com.ssafy.trip.Controller;
//
//import java.io.IOException;
//import java.sql.SQLIntegrityConstraintViolationException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.trip.dto.User;
//import com.trip.service.UserService;
//import com.trip.service.UserServiceImpl;
//
//@WebServlet("/user")
//public class UserController extends HttpServlet{
//	UserService us = UserServiceImpl.getInstance();
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		process(request, response);
//	}
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		process(request, response);
//	}
//	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		try {
//			String action = request.getParameter("action");
//			System.out.println("["+action+"]");
//			switch(action) {
//				case "find" : find(request, response); break;
//				case "login" : login(request, response); break;
//				case "logout" : logout(request, response); break;
//				case "delete" : delete(request, response); break;
//				case "update" : update(request, response); break;
//				case "view" : view(request, response); break;
//				case "regist" : regist(request, response); break;
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//			response.sendRedirect(request.getContextPath()+"/error/error.jsp");
//		}
//	}
//	private void find(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String id = request.getParameter("id");
//		User user = us.select(id);
//		request.setAttribute("password", user.getPassword());
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
//	}
//	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		String emailname = request.getParameter("emailName");
//		String domain = request.getParameter("domain");
//		String id = request.getParameter("id");
//		User user = us.select(id);
//		if(!user.getPassword().equals(password)) {
//			request.setAttribute("msg", "비밀번호가 일차하지 않습니다.");
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//			return;
//		}
//		user = new User(name, id, password, emailname, domain);
//		us.update(user);
//		HttpSession session = request.getSession();
//		session.setAttribute("userinfo", user);
//		response.sendRedirect(request.getContextPath()+"/index.jsp");
//		
//	}
//	private void regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		String repeat = request.getParameter("repeat");
//		String emailname = request.getParameter("emailName");
//		String domain = request.getParameter("domain");
//		String name = request.getParameter("name");
//		if(!password.equals(repeat)) {
//			request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//			return;
//		}
//		User user = new User(name, id, password, emailname, domain);
//		try {
//			us.insert(user);
//			request.setAttribute("msg", "회원가입이 되었습니다.");
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//		} catch (SQLIntegrityConstraintViolationException e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "이미 존재하는 아이디입니다.");
//			request.getRequestDispatcher("/index.jsp").forward(request, response);;
//		}
//	}
//	private void view(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String id = request.getParameter("id");
//		User user = us.select(id);
//		if(user != null) {
//			response.sendRedirect(request.getContextPath()+"userDetail.jsp");
//		}else {
//			request.setAttribute("msg", "존재하지 않는 회원입니다.");
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//		}
//		
//	}
//	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("userinfo");
//		String id = user.getId();
//		System.out.println(us.delete(id));
//		System.out.println(id);
//		response.sendRedirect(request.getContextPath()+"/user?action=logout");
////		request.setAttribute("msg", "존재하지 않는 회원입니다.");
////		request.getRequestDispatcher("/index.jsp").forward(request, response);
//		
//	}
//	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {		
//		HttpSession session = request.getSession();
//		session.invalidate();
//		response.sendRedirect(request.getContextPath()+ "/index.jsp");
//	}
//	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("password");
//		User user = us.select(id);
//		System.out.println(id+" "+pw);
//		System.out.println(user);
//		if(user != null && user.getPassword().equals(pw)) {
//			HttpSession session = request.getSession();
//			session.setAttribute("userinfo", user);
//			
//			String issave = request.getParameter("saveid");
//			if("ok".equals(issave)) {
//				Cookie cookie = new Cookie("saveId", id);
//				cookie.setPath(request.getContextPath());
//				cookie.setMaxAge(60*60*60*60);
//				response.addCookie(cookie);
//			} else {
//				Cookie cookies[] = request.getCookies();
//				if(cookies != null) {
//					for(Cookie c : cookies) {
//						if("saveId".equals(c.getName())) {
//							c.setMaxAge(0);
//							response.addCookie(c);
//							break;
//						}
//					}
//				}
//			}
//			request.setAttribute("msg", "로그인 되었습니다.");
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//		}
//		else {
//			request.setAttribute("msg", "아이디와 비밀번호를 다시 확인하세요!");
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//		}
//	}
//	
//}
