<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 목록</title>
</head>
<body>
<div class="container px-4 px-lg-5 mt-5" style="min-height:662px;">
	<div class="col mb-5">
		<h2 class="text-primary" align="center">공고 목록</h2>
	</div>
	<div class="col mb-5" align="right">
		<form action="annList.do">
			<input type="hidden" name="pageNum" value="1"> 
				<select name="search">
					<c:forTokens var="sh" items="ann_title,ann_location,ann_job" delims="," varStatus="i">
						<c:if test="${sh==ann.search }">
							<option value="${sh}" selected="selected">${select[i.index]}</option>
						</c:if>
						<c:if test="${sh!=ann.search }">
							<option value="${sh}">${select[i.index]}</option>
						</c:if>
					</c:forTokens>
				</select>
			<input type="text" name="keyword" value="${ann.keyword }"> 
			<input type="submit" value="확인">
		</form>
	</div>
		<c:if test="${empty annlist }">
			<div class="text-left">
				<h5 class="fw-bolder">공고 목록이 존재하지 않습니다.</h5>
			</div>
		</c:if>
		<c:if test="${not empty annlist }">
			<div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-center">
			<c:forEach var="ann" items="${annlist }">
				<div class="col mb-5">
					<div class="card h-100">
						<div class="card-body p-4">
							<div class="text-left">
								<c:set var="ann_num" value="${ann_num -1 }"></c:set>
								<p hidden="${ann_num }"></p>
								<c:if test="${ann.ann_del == 'y' }">
									<h5 class="fw-bolder mb-3">삭제된 공고입니다.</h5>
								</c:if>
								<c:if test="${ann.ann_del != 'y' }">
									<h5 class="fw-bolder mb-3">${ann.ann_title }</h5>
									<!-- com_num은 company 테이블의 주키이므로 com_num을 이용하여 com_name을 가져와 불러오도록 변경 필요 -->
									<h6 class="fw-bold mb-3">${ann.com_name }</h6>
										<ul class="list-group list-group-horizontal mb-3">
											<li class="list-group-item"> <!-- 경력 제약조건 확인 -->
												<i class="bi bi-laptop-fill"></i>&nbsp&nbsp
												<c:if test="${ann.ann_career == 'new' }">신입</c:if>
												<c:if test="${ann.ann_career == 'old' }">경력</c:if>
												<c:if test="${ann.ann_career == 'okay' }">경력무관</c:if>
											</li>
											<li class="list-group-item">
												<i class="bi bi-briefcase-fill"></i>&nbsp&nbsp
												<c:if test="${ann.ann_type == 'regular' }">정규직</c:if>
												<c:if test="${ann.ann_type == 'contract' }">계약직</c:if>
												<c:if test="${ann.ann_type == 'intern' }">인턴</c:if>
												<c:if test="${ann.ann_type == 'rest' }">기타</c:if>
											</li>
											<li class="list-group-item"><i class="bi bi-geo-alt-fill"></i>&nbsp&nbsp${ann.ann_location }</li>
										</ul>
										<table>
											<tr>
												<th width="40%">급여</th>
												<td>${ann.ann_min } ~ ${ann.ann_max } <span style="font-size: 6pt;">만원(단위)</span></td>
											</tr>
											<tr>
												<th width="40%">기간</th>
												<td>${ann.ann_recruit_period }</td>
											</tr>
											<tr>
												<th width="40%">공고일</th>
												<td>${ann.ann_regdate }</td>
											</tr>
										</table>
										<!-- 상세보기 공고 저장 버튼-->
										<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
											<div class="text-center mt-3">
											<a class="btn btn-outline-dark mt-auto" href="annView.do?ann_num=${ann.ann_num }&pageNum=${pb.currentPage}">공고 상세보기</a>
											<c:if test="${user_dist == '0' }">
											<a class="btn btn-outline-dark mt-auto" href="favSave.do?ann_num=${ann.ann_num }&pageNum=${pb.currentPage}">공고 저장</a>
											</c:if>
										</div>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
			<div align="center">
				<ul class="pagination justify-content-center">
					<!-- 시작 페이지가 pagePerBlock(10)보다 크면 앞에 보여줄 페이지가 존재하므로 버튼 생성 -->
					<c:if test="${pb.startPage > pb.pagePerBlock}">
						<li class="page-item"><a class="page-link" href="annList.do?pageNum=1&search=${ann.search }&keyword=${ann.keyword}"><span>시작</span></a></li>
						<li class="page-item"><a class="page-link" href="annList.do?pageNum=${pb.startPage - 1 }&search=${ann.search }&keyword=${ann.keyword}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					</c:if>
					<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage }">
					<!-- 선택된 페이지에 따라 활성화 부분을 BootStrap active 클래스로 잡아 준다. -->
					<c:if test="${pb.currentPage == i}">
						<li class="page-item active"><a class="page-link" href="annList.do?pageNum=${i }&search=${ann.search }&keyword=${ann.keyword}">${i }</a></li>
					</c:if>
					<c:if test="${pb.currentPage != i}">
						<li class="page-item"><a class="page-link" href="annList.do?pageNum=${i }&search=${ann.search }&keyword=${ann.keyword}">${i }</a></li>
					</c:if>
					</c:forEach>
					<!-- 보여줄 것이 많은 경우는 다음 endPage 보다 totalPage가 클 경우 -->
					<c:if test ="${pb.endPage < pb.totalPage }">
						<li class="page-item"><a class="page-link" href="annList.do?pageNum=${pb.endPage + 1 }&search=${ann.search }&keyword=${ann.keyword}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
						<li class="page-item"><a class="page-link" href="annList.do?pageNum=${pb.totalPage}&search=${ann.search }&keyword=${ann.keyword}"><span>끝</span></a></li>
					</c:if>
				</ul>
			</div>
		</c:if>
		<%-- <c:if test="${not empty com_id }"> --%> <!-- 기업회원 id로 로그인 확인 시 '공고 등록' 버튼 활성화되도록 진행 -->
			<div align="right">
				<button class="btn btn-dark" type="submit" onclick="location.href='annInsertForm.do?ann_num=0&pageNum=1'">공고 등록</button>
			</div>
		<%-- </c:if> --%>
	</div>
</body>
</html>