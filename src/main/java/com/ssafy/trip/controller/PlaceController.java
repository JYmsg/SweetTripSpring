package com.ssafy.trip.controller;
//package com.ssafy.trip.Controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.trip.dto.Gugun;
//import com.trip.dto.Place;
//import com.trip.service.GugunService;
//import com.trip.service.GugunServiceImpl;
//import com.trip.service.PlaceService;
//import com.trip.service.PlaceServiceImpl;
//import com.trip.service.PostService;
//import com.trip.service.PostServiceImpl;
//import com.trip.service.UserService;
//import com.trip.service.UserServiceImpl;
//
//@WebServlet("/place")
//public class PlaceController extends HttpServlet{
//	PlaceService ps = PlaceServiceImpl.getInstance();
//	GugunService gs = GugunServiceImpl.getInstance();
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
//				case "gugun" : gugun(request, response); break;
////				case "login" : login(request, response); break;
////				case "logout" : logout(request, response); break;
////				case "delete" : delete(request, response); break;
////				case "update" : update(request, response); break;
//				case "view" : view(request, response); break;
////				case "regist" : regist(request, response); break;
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//			response.sendRedirect(request.getContextPath()+"/error/error.jsp");
//		}
//	}
//	private void view(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		int sidoCode = Integer.parseInt(request.getParameter("sido"));
//		int gugunCode = Integer.parseInt(request.getParameter("gugun"));
//		int ContentTypeId = Integer.parseInt(request.getParameter("type"));		
//		System.out.println(sidoCode+", "+gugunCode + ", "+ ContentTypeId);
//		List<Place> places = ps.select(sidoCode, gugunCode, ContentTypeId);
//		System.out.println(places);
//		String gugun = gs.selete(gugunCode);
//		request.setAttribute("sidoCode", sidoCode);
//		request.setAttribute("gugun", gugun);
//		request.setAttribute("ContentTypeId", ContentTypeId);
//		request.setAttribute("places", places);
//		request.getRequestDispatcher("/search.jsp").forward(request, response);
//	}
//	private void gugun(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		int sidoCode = Integer.parseInt(request.getParameter("sido"));
//		System.out.println(sidoCode);
//		List<Gugun> guguns = gs.selectAll(sidoCode);
//		request.setAttribute("sidoCode", sidoCode);
//		System.out.println(guguns);
//		request.setAttribute("guguns", guguns);
////		System.out.println(guguns);
//		request.getRequestDispatcher("/search.jsp").forward(request, response);
//	}
//}
