<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/WEB-INF/views/include/header.jsp"%>
  </head>
  <body>
    <%@ include file="/WEB-INF/views/include/nav.jsp"%>
    <div class="container mt-5 justify-content-center">
      <div style="height: 70px"></div>
      <div class="row">
      <form>
        <div class="mb-3">
          <p class="fs-3 fw-bold">이름</p>
          <input id="updateName" type="text" class="form-control" name="name" value="${userinfo.name}">
        </div>
        <hr>
        <div class="mb-3">
          <p class="fs-3 fw-bold">아이디</p>
          <div id="myId" class="fs-5">${userinfo.id}</div>
          <input id="updateId" type="hidden" name="id" value="${userinfo.id}">
        </div>
        
        <hr>
        <div class="mb-3">
          <p class="fs-3 fw-bold">이메일</p>
          <input id="updateEmail" type="text" class="form-control" name="email" value="${userinfo.email}">
        </div>
        <hr>
        <div class="mb-3">
          <p class="fs-3 fw-bold">나이</p>
          <input id="updateAge" type="text" class="form-control" name="age" value="${userinfo.age}">
        </div>
        <input id="btn-update" type="button" class="btn btn-outline-primary w-20 float-end ms-2" value="수정 완료">
        <input id="btn-delete" type="button" class="btn btn-outline-danger w-20 float-end" value="탈퇴">
        </form>
        <form class="mt-3">
        </form>
      </div>
    </div>
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
  </body>
  <script>
  function updateForm() {
		let user = {};
		user.id = document.querySelector("#updateId").value;
		user.name =  document.querySelector("#updateName").value;
		user.email =  document.querySelector("#updateEmail").value;
		user.age =  document.querySelector("#updateAge").value;
		console.log(user);
		return user;
	}
    window.onload = function(){
		document.querySelector("#btn-update").addEventListener("click", function() {
			fetch("${root}/userapi/user", {
				method : "put",
				headers: {
					"Content-Type" : "application/json",
				},
				body: JSON.stringify(updateForm()),
			})
			.then((response) => response.json())
			.then((data) => {
        alert("수정 성공");
				location.href="${root}/";
			})
			.catch((error) => {
				alert("수정 실패");
			});
		})
		document.querySelector("#btn-delete").addEventListener("click", function() {
			fetch("${root}/userapi/user/"+document.querySelector("#updateId").value, {
        method: "delete"
      })
			.then((response) => response.json())
			.then((data) => {
				alert("탈퇴 성공")
				location.href="${root}/";
			})
			.catch((error) => {
				alert("탈퇴 실패")
			});
		})
	}

  </script>
</html>
