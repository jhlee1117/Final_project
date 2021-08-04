<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setAttribute("scrap_from", "1");
%>
<!-- 프로그래머스 페이지를 인식할 수 있도록 변수 추가하여 보냄 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function scrapSave(title, company, location, experience, positions, link,
			scrap_from) {
		$.post("scrapSave.do", "title=" + title + "&company=" + company
				+ "&location=" + location + "&experience=" + experience
				+ "&link=" + link + "&scrap_from=" + scrap_from, function(msg) {
			alert(msg);
		});
	}
</script>
</head>
<body>
	<div class="container px-4 px-lg-5 mt-5" style="min-height: 662px;">
		<div align="right">
			<h6>업데이트 시점: ${prDate }</h6>
		</div>
		<div class="col mb-5">
			<h2 class="text-primary" align="center">공고 목록</h2>
		</div>
		<div class="col mb-5" align="right">
			<form action="scrapProgrammers.do">
				<input type="hidden" name="pageNum" value="1"> <select
					name="search">
					<c:forTokens var="sh" items="title,company,location,positions"
						delims="," varStatus="i">
						<c:if test="${sh==search }">
							<option value="${sh}" selected="selected">${select[i.index]}</option>
						</c:if>
						<c:if test="${sh!=search }">
							<option value="${sh}">${select[i.index]}</option>
						</c:if>
					</c:forTokens>
				</select> <input type="text" name="keyword" value="${keyword }"> <input
					type="submit" value="확인">
			</form>
		</div>
		<c:if test="${empty prList }">
			<div class="text-left">
				<h5 class="fw-bolder">공고 목록이 존재하지 않습니다.</h5>
			</div>
		</c:if>
		<c:if test="${not empty prList }">
			<div
				class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-center">
				<c:forEach var="pr" items="${prList }">
					<div class="col mb-5">
						<div class="card h-100">
							<div class="card-body p-4">
								<div class="text-left">
									<h5 class="fw-bolder mb-3">${pr.title }</h5>
									<h6 class="fw-bold mb-3">${pr.company }</h6>
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item"><i class="bi bi-geo-alt-fill"></i>&nbsp&nbsp${pr.location
											}</li>
										<li class="list-group-item"><i class="bi bi-laptop-fill"></i>&nbsp&nbsp${pr.experience
											}</li>
									</ul>
									<ul class="list-group list-group-horizontal mb-3">
										<li class="list-group-item"><i
											class="bi bi-briefcase-fill"></i>&nbsp&nbsp${pr.positions }</li>
									</ul>
									<!-- 상세보기 공고 저장 버튼-->
									<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
										<div class="text-center mt-3">
											<a class="btn btn-outline-dark mt-auto" href="${pr.link }">공고
												상세보기</a>
											<c:if test="${user_dist == '0' }">
												<!-- 자바의 객체 데이터를 자바 스크립트로 읽을 수 없어서 각 값을 문자형으로 보내줌 -->
												<a class="btn btn-outline-dark mt-auto"
													onclick="scrapSave('${pr.title}','${pr.company}','${pr.location}',
										'${pr.experience}','${pr.positions}','${pr.link}', '${scrap_from}')">공고
													저장</a>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div align="center">
				<ul class="pagination justify-content-center">
 					<c:if test="${empty keyword }">
						<!-- 시작 페이지가 pagePerBlock(10)보다 크면 앞에 보여줄 페이지가 존재하므로 버튼 생성 -->
						<c:if test="${pb.startPage > pb.pagePerBlock}">
							<li class="page-item"><a class="page-link"
								href="scrapProgrammers.do?pageNum=1"><span>시작</span></a></li>
							<li class="page-item"><a class="page-link"
								href="scrapProgrammers.do?pageNum=${pb.startPage - 1 }"
								aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
						</c:if>
						<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage }">
							<!-- 선택된 페이지에 따라 활성화 부분을 BootStrap active 클래스로 잡아 준다. -->
							<c:if test="${pb.currentPage == i}">
								<li class="page-item active"><a class="page-link"
									href="scrapProgrammers.do?pageNum=${i }">${i }</a></li>
							</c:if>
							<c:if test="${pb.currentPage != i}">
								<li class="page-item"><a class="page-link"
									href="scrapProgrammers.do?pageNum=${i }">${i }</a></li>
							</c:if>
						</c:forEach>
						<!-- 보여줄 것이 많은 경우는 다음 endPage 보다 totalPage가 클 경우 -->
						<c:if test="${pb.endPage < pb.totalPage }">
							<li class="page-item"><a class="page-link"
								href="scrapProgrammers.do?pageNum=${pb.endPage + 1 }"
								aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
							<li class="page-item"><a class="page-link"
								href="scrapProgrammers.do?pageNum=${pb.totalPage}"><span>끝</span></a></li>
						</c:if>
					</c:if>
					<c:if test="${not empty keyword }">
						<!-- 시작 페이지가 pagePerBlock(10)보다 크면 앞에 보여줄 페이지가 존재하므로 버튼 생성 -->
						<c:if test="${pb.startPage > pb.pagePerBlock}">
							<li class="page-item"><a class="page-link"
								href="scrapProgrammers.do?pageNum=1&search=${search }&keyword=${keyword}"><span>시작</span></a></li>
							<li class="page-item"><a class="page-link"
								href="scrapProgrammers.do?pageNum=${pb.startPage - 1 }&search=${search }&keyword=${keyword}"
								aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
						</c:if>
						<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage }">
							<!-- 선택된 페이지에 따라 활성화 부분을 BootStrap active 클래스로 잡아 준다. -->
							<c:if test="${pb.currentPage == i}">
								<li class="page-item active"><a class="page-link"
									href="scrapProgrammers.do?pageNum=${i }&search=${search }&keyword=${keyword}">${i }</a></li>
							</c:if>
							<c:if test="${pb.currentPage != i}">
								<li class="page-item"><a class="page-link"
									href="scrapProgrammers.do?pageNum=${i }&search=${search }&keyword=${keyword}">${i }</a></li>
							</c:if>
						</c:forEach>
						<!-- 보여줄 것이 많은 경우는 다음 endPage 보다 totalPage가 클 경우 -->
						<c:if test="${pb.endPage < pb.totalPage }">
							<li class="page-item"><a class="page-link"
								href="scrapProgrammers.do?pageNum=${pb.endPage + 1 }&search=${search }&keyword=${keyword}"
								aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
							<li class="page-item"><a class="page-link"
								href="scrapProgrammers.do?pageNum=${pb.totalPage}&search=${search }&keyword=${keyword}"><span>끝</span></a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
		</c:if>
	</div>
</body>
</html>