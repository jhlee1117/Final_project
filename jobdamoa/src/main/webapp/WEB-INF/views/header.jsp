<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<body>
	<div id="carouselScrap" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">
 			<div class="carousel-inner">
<%--     			<div class="carousel-item active" id="jobkorea">
      				<img src="${path }/resources/template/img/logo_jobkorea.png" class="img-fluid mx-auto d-block w-25" alt="...">
    			</div> --%>
   			<div class="carousel-item active" id="programmers">
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
</body>
</html>