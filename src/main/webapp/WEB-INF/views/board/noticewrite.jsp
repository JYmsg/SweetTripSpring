<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/WEB-INF/views/include/header.jsp"%>
  </head>
  <body>
    <%@ include file="/WEB-INF/views/include/nav.jsp"%>
    <section class="page-section container">
      <div class="text-center">
        <span class="mt-3 h3 d-inline-block" id="tripListTitle">공지사항 작성</span>
      </div>
      <form class="was-validated" method="post" action="${root}/noticelist">
        <div class="mb-4" id="write-title-div">
          <label for="title" class="h5">제목</label>
          <input type="text" class="form-control" id="writeTitle" name="title" placeholder="제목을 입력하세요" required />
          <div class="invalid-feedback">제목을 입력하세요</div>
        </div>
        <div class="mb-4" id="write-content-div">
          <label for="content" class="h5">내용</label>
          <textarea
            class="form-control"
            id="writeContent"
            placeholder="내용을 입력하세요"
            rows="10"
            name="content" 
            required
          ></textarea>
          <div class="invalid-feedback">내용을 입력하세요</div>
        </div>
        <div class="mt-5 text-center">
          <button id="writeDone" type="submit" class="btn btn-outline-warning">작성 완료</button>
        </div>
      </form>
    </section>
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
  </body>
</html>
