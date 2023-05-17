<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/WEB-INF/views/include/header.jsp"%>
  </head>
  <body>
    <%@ include file="/WEB-INF/views/include/nav.jsp"%>
     <!--main-->
    <section class="page-section container text-center">
      <h2 class="section-heading text-uppercase my-5">ENJOY TRIP</h2>
      <a class="btn btn-outline-warning float-end d-inline mb-3" href="${root }/noticewrite">글쓰기</a>
      	  <div id="noticeListBox" style="clear: both">
	        <table class="table">
	          <thead>
	            <tr>
	              <th scope="col">번호</th>
	              <th scope="col">제목</th>
	              <th scope="col">작성자</th>
	              <th scope="col">조회수</th>
	              <th scope="col">작성일</th>
	            </tr>
	          </thead>
	          <tbody>
	           <c:if test="${not empty notices}">
		          	<c:forEach items="${notices}" var="notice" varStatus="vs">
		            <tr>
		              <th scope="row">${vs.count}</th>
		              <td><a href="${root}/noticeview?id=${notice.id}">${notice.title}</a></td>
		              <td>${notice.writer_id}</td>
		              <td>${notice.hit}</td>
		              <td>${notice.write_time}</td>
		            </tr>
		          	</c:forEach>
	           </c:if>
	          <c:if test="${empty notices}">
		      	<tr>
		          <td colspan="5">등록된 공지사항이 없습니다</td>
		        </tr>
		      </c:if>
	          </tbody>
	        </table>
	      </div>
    </section>
    <%@ include file="/WEB-INF/views/include/paging.jsp" %>
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
  </body>
</html>