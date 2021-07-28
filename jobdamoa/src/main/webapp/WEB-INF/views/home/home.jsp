<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<body>
	<div class="container px-4 px-lg-5 mt-5">
		<div id="recentAnnouncement" class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-5 justify-content-center">
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
	                           ${recentList.location }
	                           ${recentList.experience }
	                           ${recentList.positions }
							</div>
	                   </div>
	                   <!-- Product actions-->
	                   <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                       <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${recentList.link }">바로가기</a></div>
	                   </div>
	               </div>
	           </div>
               </c:forEach>
			</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>