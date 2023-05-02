<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
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
        <span class="text-center mt-5 h3 d-inline-block">${hotpl.title}</span>
        <div class="dropdown">
             <i id="threeDot" class="bi bi-three-dots fs-3" data-bs-toggle="dropdown" aria-expanded="false"></i>
             <ul class="dropdown-menu">
                 <li><a class="dropdown-item" href="${root}/hotplupdate?id=${hotpl.id}">수정</a></li>
                 <li><a class="dropdown-item" href="${root}/hotpldel?id=${hotpl.id}">삭제</a></li>
             </ul>
        </div>
        <i id="like" class="bi fs-4 ${cookie.setLikeClass.value}" style="color:#${cookie.setLikeColor.value};"></i>
      </div>
      <h3 class="section-subheading text-muted">${hotpl.write_time} <br> ${hotpl.writer_id}</h3>
      <img class="w-100" src="${root }/assets/resources/upload/${hotpl.img}" />
      <div id="view" class="textBox text-start mt-3">
        <p>
         ${hotpl.content}
        </p>
      </div>
      <div class="text-end">
      	<a class="btn" href="${root}/hotplacelist">목록 보기</a>
      </div>
    </section> 
<!--    
    <script>
	    const likeBtn = document.getElementById("like");
	    let isLike = ("${cookie.setLikeColor.value}"=="black")? false : true;
	    likeBtn.addEventListener("click", () => {
	      if(!isLike){
	    	  location.href="${root}/main?action=reviewAddLike&articleNo=${review.articleNo}";
	      }
	      else {
	    	  location.href="${root}/main?action=reviewRemoveLike&articleNo=${review.articleNo}";
	      }
	    });
    </script>-->  
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
  </body>
</html>
