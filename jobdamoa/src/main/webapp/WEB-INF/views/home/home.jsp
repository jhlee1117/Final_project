<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<!-- 
<script type="text/javascript">
	var myCarousel = document.getElementById('myCarousel')
	myCarousel.addEventListener('slide.bs.carousel', function () {
		
	})
</script>
 -->
<body>
	<header class="bg-dark py-5">
		<div id="carouselScrap" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">
  			<div class="carousel-inner">
    			<div class="carousel-item active" id="jobkorea">
      				<img src="${path }/resources/template/img/logo_jobkorea.png" class="img-fluid mx-auto d-block w-25" alt="...">
    			</div>
    			<div class="carousel-item" id="programmers">
      				<img src="${path }/resources/template/img/logo_programmers.png" class="img-fluid mx-auto d-block w-25" alt="...">
    			</div>
    			<div class="carousel-item" id="saramin">
      				<img src="${path }/resources/template/img/logo_saramin.png" class="img-fluid mx-auto d-block w-25" alt="...">
    			</div>
  			</div>
  			<button class="carousel-control-prev" type="button" data-bs-target="#carouselScrap" data-bs-slide="prev">
    			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    			<span class="visually-hidden">Previous</span>
  			</button>
  			<button class="carousel-control-next" type="button" data-bs-target="#carouselScrap" data-bs-slide="next">
	    		<span class="carousel-control-next-icon" aria-hidden="true"></span>
    			<span class="visually-hidden">Next</span>
  			</button>
		</div>
	</header>
	<!--  
	<div class="container-fluid">
	<div id="recentAnnouncement" class="vertical">
		<c:choose>
		<c:when test="${myCarousel == programmers }">
			<c:when test="${prRecentList == null}">
				<span>채용공고가 없습니다.</span>
			</c:when>
			<c:when test="${prRecentList != null}">
				<c:forEach var="recentList" items="${prRecentList}" begin="0" end="4" step="1" varStatus="status">
				<div class="card text-dark bg-light mb-3" style="max-width: 25rem;">
			 		<div class="card-header"><h5>${recentList.title}</h5></div>
			  		<div class="card-body">
			    		<h5 class="card-title">${recentList.company}</h5>
			    		<p class="card-text">${recentList.location }</p>
			    		<p class="card-text">${recentList.experience }</p>
			    		<p class="card-text">${recentList.positions }</p>
			    		<a href="${recentList.link }" class="btn btn-primary">바로가기</a>
			  		</div>
				</div>
				</c:forEach>
			</c:when>
		</c:when>
		</c:choose>
	</div>
	</div>
	-->
</body>
</html>