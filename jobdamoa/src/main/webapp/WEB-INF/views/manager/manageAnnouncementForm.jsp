<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
<div class="container px-4 px-lg-5 mt-5" style="min-height:662px">
	<div class="mt-5 mb-5" align="center">
		<font color="black" size="6">채용공고관리</font>
	</div>
	<div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-center">
		<table class="table table-hover">
			<thead class="table-primary">
			<tr class="table-dark">
				<th>회사명</th>
				<th>공고상태</th>
				<th>공고명</th>
				<th>공고시점</th>
				<th>조회 수</th>
				<th colspan="3" style="text-align: center">공고 관리</th>
			</tr>
			</thead>
			<tbody class="table-dark">
			<c:if test="${empty annlist }">
				<tr class="table-dark">
					<th colspan="7" style="text-align: center">공고 목록이 존재하지 않습니다.</th>
				</tr>
			</c:if>
			<c:if test="${not empty annlist }">
				<c:forEach var="ann" items="${annlist }">
					<tr class="table-dark">
						<td>${ann.com_name }</td>
						<td>
							<c:if test="${ann.ann_del == 'y' }">종료</c:if>
							<c:if test="${ann.ann_del == 'n' }">공고 중</c:if>
						</td>
						<td>${ann.ann_title }</td>
						<td>${ann.ann_regdate }</td>
						<td>${ann.ann_view }</td>
						<td style="text-align: center">
							<a class="btn btn-info btn-sm" href="annView.do?ann_num=${ann.ann_num}&pageNum=${pb.currentPage}">공고 상세보기</a>
						</td>
						<td style="text-align: center">
							<a class="btn btn-info btn-sm" href="annDeleteForm.do?ann_num=${ann.ann_num}&pageNum=${pb.currentPage}">공고 삭제123</a>
						</td>
				</c:forEach>
			</c:if>
			</tbody>
		</table>
	</div>
	<div align="center">
		<ul class="pagination justify-content-center">
			<!-- 시작 페이지가 pagePerBlock(10)보다 크면 앞에 보여줄 페이지가 존재하므로 버튼 생성 -->
			<c:if test="${pb.startPage > pb.pagePerBlock}">
				<li class="page-item"><a class="page-link" href="manageAnnouncementForm.do?pageNum=1"><span>시작</span></a></li>
				<li class="page-item"><a class="page-link" href="manageAnnouncementForm.do?pageNum=${pb.startPage - 1 }" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			</c:if>
			<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage }">
				<!-- 선택된 페이지에 따라 활성화 부분을 BootStrap active 클래스로 잡아 준다. -->
				<c:if test="${pb.currentPage == i}">
					<li class="page-item active"><a class="page-link" href="manageAnnouncementForm.do?pageNum=${i }">${i }</a></li>
				</c:if>
				<c:if test="${pb.currentPage != i}">
					<li class="page-item"><a class="page-link" href="manageAnnouncementForm.do?pageNum=${i }">${i }</a></li>
				</c:if>
			</c:forEach>
				<!-- 보여줄 것이 많은 경우는 다음 endPage 보다 totalPage가 클 경우 -->
			<c:if test ="${pb.endPage < pb.totalPage }">
				<li class="page-item"><a class="page-link" href="manageAnnouncementForm.do?pageNum=${pb.endPage + 1 }" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				<li class="page-item"><a class="page-link" href="manageAnnouncementForm.do?pageNum=${pb.totalPage}"><span>끝</span></a></li>
			</c:if>
		</ul>
	</div>
</div>
</body>
</html>