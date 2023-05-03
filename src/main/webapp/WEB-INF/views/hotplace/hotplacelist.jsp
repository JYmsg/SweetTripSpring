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
     <!--main-->
    <section class="page-section container text-center">
      <h2 class="section-heading text-uppercase my-5">🔥핫 플레이스🔥</h2>
      <a class="btn btn-outline-warning float-end d-inline mb-3" href="${root }//hotplaceregist">핫 플레이스 등록하기</a>
      <div id="postListBox" style="clear: both">
      	<c:if test="${not empty hotpls}">
      		<c:forEach items="${hotpls}" var="hotpl">
      			<div class="card mb-3 text-start">
		          <div class="row g-0">
		            <div class="col-md-3">
		              <img style="height : 200px; width: 300px" src="${root }/assets/resources/upload/${hotpl.img}" class="img-fluid rounded-start" />
		            </div>
		            <div class="col-md-9">
		              <div class="card-body">
		                <div class="d-flex justify-content-between align-items-center">
		                 	<div><a class="card-title m-0 h5" href="${root}/hotplacedetail?id=${hotpl.id}">${hotpl.title}</a></div>
		                	<div>
		                		<i id="like" class="bi bi-heart fs-4"></i><br>
		                   		<span>좋아요 ${hotpl.like}</span><br>
		                   		<span>조회수 ${hotpl.hit}</span>
		                	</div>
		                </div>
		                <p class="card-text">
		                	<small class="text-muted">작성자: ${hotpl.writer_id}</small><br>
		                	<small class="text-muted">${hotpl.write_time}</small>
		                </p>
		              </div>
		            </div>
		          </div>
		        </div>
      		</c:forEach>
      	</c:if>
      	<c:if test="${empty hotpls}">
      		<p>등록된 게시물이 없습니다</p>
      	</c:if>
      </div>
    </section>
    <%@ include file="/WEB-INF/views/include/paging.jsp" %>
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
  </body>
</html>
