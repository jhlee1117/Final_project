<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<body>
	<header class="bg-dark py-5">
		<div id="carouselScrap" class="carousel slide" data-bs-ride="carousel"
			data-bs-interval="false">
			<div class="carousel-inner">
				<%--     			<div class="carousel-item active" id="jobkorea">
      				<img src="${path }/resources/template/img/logo_jobkorea.png" class="img-fluid mx-auto d-block w-25" alt="...">
    			</div> --%>
				<div class="carousel-item active" id="programmers">
					<a href="https://programmers.co.kr"><img src="${path }/resources/template/img/logo_programmers.png"
						class="img-fluid mx-auto d-block w-25" alt="..."></a>
				</div>
				<div class="carousel-item" id="saramin">
					<a href="https://www.saramin.co.kr"><img src="${path }/resources/template/img/logo_saramin.png"
						class="img-fluid mx-auto d-block w-25" alt="..."></a>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselScrap" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselScrap" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</header>

	<div class="container px-4 px-lg-5 mt-5" style="min-height:410px;">
		<div id="recentAnnouncement1">
		<div>
			<h4>프로그래머스 최신 공고</h4>
		</div>
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-5 justify-content-center">
			<c:choose>
			<c:when test="${prRecentList == null}">
				<span>채용공고가 없습니다.</span>
			</c:when>
			<c:when test="${prRecentList != null}">
				<c:forEach var="recentList" items="${prRecentList}" begin="0" end="4" step="1" varStatus="status">
				<div class="col mb-5">
					<div class="card h-100">
						<div class="card-header"><h5>${recentList.title}</h5></div>   
	                   <!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
	                           <!-- 회사이름 -->
	                           <h5 class="fw-bolder">${recentList.company}</h5>
	                           <!-- 채용정보 -->
	                           ${recentList.location }<br>
	                           ${recentList.experience }<br>
	                           ${recentList.positions }
							</div>
	                   </div>
	                   <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                       <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${recentList.link }">바로가기</a></div>
	                   </div>
	               </div>
	           </div>
               </c:forEach>
			</c:when>
			</c:choose>
		</div></div>
		<div id="recentAnnouncement2">
		<div>
			<h4>사람인 최신 공고</h4>
		</div>
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-5 justify-content-center">
			<c:choose>
			<c:when test="${saRecentList == null}">
				<span>채용공고가 없습니다.</span>
			</c:when>
			<c:when test="${saRecentList != null}">
				<c:forEach var="recentList" items="${saRecentList}" begin="0" end="4" step="1" varStatus="status">
				<div class="col mb-5">
					<div class="card h-100">
						<div class="card-header"><h5>${recentList.title}</h5></div>   
	                   <!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
	                           <!-- 회사이름 -->
	                           <h5 class="fw-bolder">${recentList.company}</h5>
	                           <!-- 채용정보 -->
	                           ${recentList.location }<br>
	                           ${recentList.experience }<br>
	                           ${recentList.positions }
							</div>
	                   </div>
	                   <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                       <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${recentList.link }">바로가기</a></div>
	                   </div>
	               </div>
	           </div>
               </c:forEach>
			</c:when>
			</c:choose>
		</div>
	</div></div>
<script>
	var myCarousel = document.getElementById('carouselScrap')
	
	myCarousel.addEventListener('slide.bs.carousel', function () {
		document.getElementById('recentAnnouncement1').style.background_color="blue";
	})
</script>
</body>

</html>