<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function scrapSave(title, company, location, experience, positions, link) {
		$.post("scrapSave.do", "title=" + title + "&company=" + company + "&location="
				+ location + "&experience=" + experience + "&link=" + link,
			function(msg) {
				alert(msg);
			});
	}
</script>
</head>
<body>
<div class="container px-4 px-lg-5 mt-5">
	<div class="col mb-5">
		<h2 class="text-primary" align="center">공고 목록</h2>
	</div>
		<c:if test="${empty prList }">
			<div class="text-left">
				<h5 class="fw-bolder">공고 목록이 존재하지 않습니다.</h5>
			</div>
		</c:if>
		<c:if test="${not empty prList }">
			<div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-center">
			<c:forEach var="pr" items="${prList }">
				<div class="col mb-5">
					<div class="card h-100">
						<div class="card-body p-4">
							<div class="text-left">
								<h5 class="fw-bolder mb-3">${pr.title }</h5>
								<h6 class="fw-bold mb-3">${pr.company }</h6>
									<ul class="list-group list-group-horizontal mb-3">
										<li class="list-group-item">${pr.location }</li>
										<li class="list-group-item">${pr.experience }</li>
										<li class="list-group-item">${pr.positions }</li>
									</ul>
										<!-- 상세보기 공고 저장 버튼-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center mt-3">
										<a class="btn btn-outline-dark mt-auto" href="${pr.link }">공고 상세보기</a>
									<c:if test="${user_dist == '0' }">
										<!-- 자바의 객체 데이터를 자바 스크립트로 읽을 수 없어서 각 값을 문자형으로 보내줌 -->
										<a class="btn btn-outline-dark mt-auto" onclick="scrapSave('${pr.title}','${pr.company}','${pr.location}',
										'${pr.experience}','${pr.positions}','${pr.link}')">공고 저장</a>
									</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
		</c:if>
</div>
</body>
</html>