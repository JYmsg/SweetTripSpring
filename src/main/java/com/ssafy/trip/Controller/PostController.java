//package com.ssafy.trip.Controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.trip.dto.Post;
//import com.trip.service.PostService;
//import com.trip.service.PostServiceImpl;
//
//@WebServlet("/post")
//public class PostController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public PostController() {
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		process(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		process(request, response);
//
//	}
//
//	static PostService svc = PostServiceImpl.getInstance();
//
//	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		try {
//			String action = request.getParameter("action");
//			System.out.println("액션: " + action);
//			switch (action) {
//			case "write":
//				write(request, response);
//				break;
//			case "delete":
//				delete(request, response);
//				break;
//			case "find":
//				find(request, response);
//				break;
//			case "findAll":
//				findAll(request, response);
//				break;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			response.sendRedirect(request.getContextPath() + "/error/error.jsp");
//		}
//	}
//
//	private void write(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("작성");
////		System.out.println(request.getParameter("title"));
////		System.out.println(request.getParameter("content"));
//		Post data = new Post();
//		data.setId("PK");
//		data.setTitle(request.getParameter("title"));
//		data.setContent(request.getParameter("content"));
//		data.setAuthor("작성자");
//		svc.setPost(data);
//		response.sendRedirect(request.getContextPath() + "/post?action=findAll");
//	}
//
//	private void delete(HttpServletRequest request, HttpServletResponse response) {
//
//	}
//
//	private void find(HttpServletRequest request, HttpServletResponse response) {
//
//	}
//
//	private void findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setAttribute("posts", svc.getPostList());
//		request.getRequestDispatcher("/post.jsp").forward(request, response);
//	}
//}
