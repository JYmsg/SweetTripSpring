<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/include/header.jsp" %>
  </head>
  <body>
    <%@ include file="/include/nav.jsp" %>
    <section id="trophy" class="d-flex align-items-center">
    <div class="container d-flex flex-column align-items-center trophy" data-aos="zoom-in" data-aos-delay="100">
      <h1 style="color : #b8860b">✨명예의 전당✨</h1>
      <h2 style="color : #ffc800">이번달 게시글을 가장 많이 올린 회원을 발표합니다!</h2>
      <br>
      <br>
      <c:forEach var="user" items="${topusers}" varStatus="vs" >
      <h4>${vs.count}위 ${user}</h4>
      </c:forEach>
      <br>
      <br>
      <h2>적극적인 이용에 감사드립니다!</h2>
    </div>
  	</section>
    <%@ include file="/include/footer.jsp" %>
  </body>
</html>

