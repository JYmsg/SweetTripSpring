//package com.ssafy.trip.model.repo;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.UUID;
//
//import com.trip.dto.Post;
//import com.trip.dto.User;
//import com.trip.util.DBUtil;
//
//public class PostDaoImpl implements PostRepo {
//
//	private PostDaoImpl() {
//	}
//
//	private static PostRepo instance = new PostDaoImpl();
//
//	public static PostRepo getInstance() {
//		return instance;
//	}
//
//	// DB가져오기
//	DBUtil util = DBUtil.getInstance();
//
//	@Override
//	public ArrayList<Post> getPostList() throws Exception {
//		ArrayList<Post> list = new ArrayList<>();
//		String sql = "select * from post";
//
//		try (Connection conn = util.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				Post postData = new Post();
//				postData.setId(rs.getString("id"));
//				postData.setTitle(rs.getString("title"));
//				postData.setContent(rs.getString("content"));
//				postData.setAuthor(rs.getString("author"));
//				list.add(postData);
//			}
//		}
//		return list;
//
//	}
//
//	@Override
//	public Post getPost(String id) throws Exception {
//		Post postData = null;
//		String sql = "select * from post where id=?";
//		try (Connection conn = util.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			pstmt.setString(1, id);
//			ResultSet rs = pstmt.executeQuery();
//			if (rs.next()) {
//				postData = new Post();
//				postData.setId(rs.getString("id"));
//				postData.setTitle(rs.getString("title"));
//				postData.setContent(rs.getString("content"));
//				postData.setAuthor(rs.getString("author"));
//			}
//		}
//		return postData;
//	}
//
//	@Override
//	public int setPost(Post post) throws Exception {
//		String sql = "insert into post (id,title,content,author) values(?,?,?,?)";
//
//		try (Connection conn = util.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			String pk = UUID.randomUUID().toString();
//			pstmt.setString(1, pk);
////			pstmt.setString(2, "제목3");
////			pstmt.setString(3, "내용33");
////			pstmt.setString(4, "강호동");
//			pstmt.setString(2, post.getTitle());
//			pstmt.setString(3, post.getContent());
//			pstmt.setString(4, post.getAuthor());
//			pstmt.executeUpdate();
//		}
//
//		return 0;
//	}
//
//	@Override
//	public int deletePost(String id) throws Exception {
//		String sql = "delete from post where id=?";
//		try (Connection conn = util.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			pstmt.setString(1, id);
//			return pstmt.executeUpdate();
//		}
//	}
//
//	public static void main(String[] args) throws Exception {
//		PostRepo dao = PostDaoImpl.getInstance();
//		Post testPost = new Post();
//		dao.deletePost("35c4c18d-e446-4b5d-9ec2-158889a5e58a");
//		System.out.println(dao.getPostList());
//	}
//}
