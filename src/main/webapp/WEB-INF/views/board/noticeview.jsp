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
      <div id="titleBox">
        <span class="text-center mt-5 h3 d-inline-block">${notice.title}</span>
        <div class="dropdown">
             <i id="threeDot" class="bi bi-three-dots fs-3" data-bs-toggle="dropdown" aria-expanded="false"></i>
             <ul class="dropdown-menu">
                 <li><a class="dropdown-item" href="${root}/noticeupdate?id=${notice.id}">수정</a></li>
                 <li><a class="dropdown-item" href="${root}/noticedel?id=${notice.id}">삭제</a></li>
             </ul>
        </div>
      </div>
      <h3 class="section-subheading text-muted">${notice.write_time} <br> ${notice.writer_id}</h3>
      <hr>
      <br>
      <div id="view" class="textBox text-center text-start mt-3">
        <p>
         ${notice.content}
        </p>
      </div>
      <div class="text-end">
      	<a class="btn" href="${root}/noticelist">목록 보기</a>
      </div>
    </section> 
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
  </body>
</html>