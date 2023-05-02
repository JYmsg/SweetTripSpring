<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/WEB-INF/views/include/header.jsp"%>
  </head>
  <body>
    <%@ include file="/WEB-INF/views/include/nav.jsp"%>
    <header class="masthead">
      <div class="container">
        <a class="btn btn-secondary btn-xl rounded-5 w-100 text-center" href="./tripList.jsp">
          <i class="bi bi-search"></i> 어디든지 언제든지
        </a>
      </div>
    </header>

    <!-- Portfolio Grid-->
    <section class="page-section bg-light" id="portfolio">
    	<div class="container">
	        <div class="text-center">
	          <h2 class="section-heading text-uppercase">지금 가장 핫한🔥 여행지</h2>
	          <h3 class="section-subheading text-muted">Hot Place를 구경해보세요!</h3>
	        </div>
	        <c:if test="${not empty hotpls }">
	        	<a class="btn btn-outline-warning d-inline float-end mb-3" href="${root}/hotplacelist">여행지 더보기</a>
					<div class="row" style="clear: both">
						<c:forEach var="hotpl" items="${hotpls }">
							<div class="col-lg-4 col-sm-6 mb-4">
					            <div class="portfolio-item">
					              <a class="portfolio-link" href="${root }/hotplacedetail?id=${hotpl.id}">
					                <div class="portfolio-hover">
					                	<div class="portfolio-hover-content">
					                  		<i class="bi bi-plus-lg fs-1"></i>
					                  	</div>
					                </div>
					                <img class="img-fluid" src="${root }/assets/resources/upload/${hotpl.img}" />
					              </a>
					              <div class="portfolio-caption">
					                <div class="portfolio-caption-heading">${hotpl.title }</div>
					                <div class="portfolio-caption-subheading text-muted">${hotpl.write_time }</div>
					              </div>
					            </div>
					         </div>
						</c:forEach>
					</div>
			</c:if>
			<c:if test="${empty hotpls }">
				<p>등록된 장소가 없습니다.</p>
				<p>나만의 핫 플레이스를 등록해 보세요!</p>
				<a class="btn btn-outline-warning d-inline float-end mb-3" href="${root}/hotplaceregist">핫 플레이스 등록하기</a>
			</c:if>
		</div>
    </section>
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
  </body>
</html>
