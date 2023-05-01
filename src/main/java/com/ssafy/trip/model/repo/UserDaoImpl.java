//package com.ssafy.trip.model.repo;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import com.trip.dto.User;
//import com.trip.util.DBUtil;
//
//public class UserDaoImpl implements UserRepo{
//	private UserDaoImpl() {}
//	private static UserRepo instance = new UserDaoImpl();
//	public static UserRepo getInstance() {
//		return instance;
//	}
//	DBUtil util = DBUtil.getInstance();
//	@Override
//	public User select(String id) throws Exception {
//		User user = null;
//		String sql = "select * from users where id=?";
//		try(
//				Connection conn = util.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);){
//			pstmt.setString(1, id);
//			try(ResultSet rs = pstmt.executeQuery();){
//				if(rs.next()) {
//					user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//				}
//			}
//		}
//		return user;
//	}
//
//	@Override
//	public int delete(String id) throws Exception {
//		String sql = "delete from users where id=?";
//		try(
//				Connection conn = util.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);){
//			pstmt.setString(1, id);
//			return pstmt.executeUpdate();
//		}
//	}
//
//	@Override
//	public int insert(User user) throws Exception {
//		String sql = "insert into users values (?, ?, ?, ?, ?)";
//		try(
//				Connection conn = util.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);){
//			pstmt.setString(1, user.getName());
//			pstmt.setString(2, user.getId());
//			pstmt.setString(3, user.getPassword());
//			pstmt.setString(4, user.getEmailname());
//			pstmt.setString(5, user.getDomain());
//			return pstmt.executeUpdate();
//		}
//	}
//
//	@Override
//	public int update(User user) throws Exception {
//		String sql = "update users set name=?, emailname=?, domain=? where id=?";
//		try(
//				Connection conn = util.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);){
//			pstmt.setString(1, user.getName());
//			pstmt.setString(2, user.getEmailname());
//			pstmt.setString(3, user.getDomain());
//			pstmt.setString(4, user.getId());
//			return pstmt.executeUpdate();
//		}
//	}
//	
////	public static void main(String[] args) throws Exception{
////		UserDao dao = new UserDaoImpl();
//////		System.out.println(dao.select("admin"));
////		dao.insert(new User("test", "test", "test", ""));
////		System.out.println(dao.select("test"));
////		dao.delete("test");
////		System.out.println(dao.select("test"));
////	}
//}
