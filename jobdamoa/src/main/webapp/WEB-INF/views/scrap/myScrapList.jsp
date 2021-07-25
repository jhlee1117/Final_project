<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function delchk(scrap_num) {
		var delchk = confirm("저장된 공고를 삭제하시겠습니까?");
		var pageNum = '${pb.currentPage}';
		if (delchk == true) {
			$.post("scrapDelete.do", "scrap_num=" + scrap_num + "&pageNum=" + pageNum,
				function(msg) {
				alert(msg);
			});
		} else
			return;
		location.reload();
	}
</script>
</head>
<body>
<div class="container px-4 px-lg-5 mt-5">
	<div class="col mb-5">
		<h2 class="text-primary" align="center">내가 저장한 공고</h2>
	</div>
	<div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-center">
		<table class="table table-striped">
			<tr>
				<th>공고출처</th>
				<th>공고명</th>
				<th>회사명</th>
				<th>근무지</th>
				<th>경력</th>
				<th>공고 관리</th>
			</tr>
			<c:if test="${empty myscraplist }">
				<tr>
					<th colspan="7" style="text-align: center">저장한 공고가 존재하지 않습니다.</th>
				</tr>
			</c:if>
			<c:if test="${not empty myscraplist }">
				<c:forEach var="myscrap" items="${myscraplist }">
					<tr>
						<td>
							<c:if test="${myscrap.scrap_from eq '1' }">
								<img src="${path }/resources/template/img/mini-logo_programmers.png" class="img-fluid mx-auto d-block" width="100px">
							</c:if>
							<c:if test="${myscrap.scrap_from eq '2' }">
								<img src="${path }/resources/template/img/mini-logo_saramin.png" class="img-fluid mx-auto d-block" width="100px">
							</c:if>
						</td>
						<td><a href="${myscrap.scrap_link }">${myscrap.scrap_title }</a></td>
						<td>${myscrap.scrap_company }</td>
						<td>${myscrap.scrap_location }</td>
						<td>${myscrap.scrap_career }</td>
						<td style="text-align: center">
							<a class="btn btn-info btn-sm" onclick="delchk(${myscrap.scrap_num});" <%-- href="favDelete.do?ann_num=${myfav.announcement.ann_num}&pageNum=${pb.currentPage}" --%>>공고 삭제</a>
						</td>
				</c:forEach>
			</c:if>
		</table>
	</div>
	<div align="center">
		<ul class="pagination justify-content-center">
			<!-- 시작 페이지가 pagePerBlock(10)보다 크면 앞에 보여줄 페이지가 존재하므로 버튼 생성 -->
			<c:if test="${pb.startPage > pb.pagePerBlock}">
				<li class="page-item"><a class="page-link" href="myScrapList.do?pageNum=1"><span>시작</span></a></li>
				<li class="page-item"><a class="page-link" href="myScrapList.do?pageNum=${pb.startPage - 1 }" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			</c:if>
			<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage }">
				<!-- 선택된 페이지에 따라 활성화 부분을 BootStrap active 클래스로 잡아 준다. -->
				<c:if test="${pb.currentPage == i}">
					<li class="page-item active"><a class="page-link" href="myScrapList.do?pageNum=${i }">${i }</a></li>
				</c:if>
				<c:if test="${pb.currentPage != i}">
					<li class="page-item"><a class="page-link" href="myScrapList.do?pageNum=${i }">${i }</a></li>
				</c:if>
			</c:forEach>
				<!-- 보여줄 것이 많은 경우는 다음 endPage 보다 totalPage가 클 경우 -->
			<c:if test ="${pb.endPage < pb.totalPage }">
				<li class="page-item"><a class="page-link" href="myScrapList.do?pageNum=${pb.endPage + 1 }" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				<li class="page-item"><a class="page-link" href="myScrapList.do?pageNum=${pb.totalPage}"><span>끝</span></a></li>
			</c:if>
		</ul>
	</div>
</div>
</body>
</html>