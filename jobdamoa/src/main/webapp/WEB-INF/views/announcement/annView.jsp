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
	var script = document.createElement('script');
	script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=d2196f3ead15c9e78a17ba1c74506591";
	document.head.appendChild(script);
	var container = document.getElementById("map");
	var options = {	center: new kakao.maps.LatLng(33.450701, 126.570667), level: 3
					};
	var map = new kakao.maps.Map(container, options);		
</script>
</head>
<body>
	<div class="container px-4 px-lg-5 mt-5">
		<div
			class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-left">
			<div class="col-8 mb-4">
				<h2 class="h2">${ann.ann_title}</h2>
				<h4 class="h4">${com.com_name }</h4>
			</div>
			<div class="col-4 mb-5">
				<c:if test="${user_dist == '0' }">
					<a class="btn btn-outline-dark mt-auto" href="favSave.do?ann_num=${ann.ann_num }&pageNum=${pageNum}">공고 저장하기</a>
				</c:if>
			</div>
		</div>
		<div
			class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-left">
			<div class="col-8 mb-4">
				<div class="section">
					<h5 class="h5">요약</h5>
					<table class="table table-bordered">
						<tr>
							<th width="30%" valign="middle">직무</th>
							<td>${ann.ann_job }</td>
						</tr>
						<tr>
							<th width="30%" valign="middle">고용형태</th>
							<td><c:if test="${ann.ann_type == 'regular' }">
								정규직
							</c:if> <c:if test="${ann.ann_type == 'contract' }">
								계약직
							</c:if> <c:if test="${ann.ann_type == 'intern' }">
								인턴
							</c:if> <c:if test="${ann.ann_type == 'rest' }">
								기타
							</c:if></td>
						</tr>
						<tr>
							<th width="30%" valign="middle">경력</th>
							<td><c:if test="${ann.ann_career == 'new' }">
								신입
							</c:if> <c:if test="${ann.ann_career == 'old' }">
								경력
							</c:if> <c:if test="${ann.ann_career == 'okay' }">
								경력무관
							</c:if></td>
						</tr>
						<tr>
							<th width="30%" valign="middle">연봉</th>
							<td>${ann.ann_min } ~ ${ann.ann_max } 만원</td>
						</tr>
						<tr>
							<th width="30%" valign="middle">회사 규모</th>
							<td>${com.com_emp_num }명</td>
						</tr>
						<tr>
							<th width="30%" valign="middle">기간</th>
							<td>${ann.ann_recruit_period }</td>
						</tr>
						<tr>
							<th width="30%" valign="middle">근무위치</th>
							<td>${ann.ann_location }</td>
						</tr>
					</table>
					<div class="mb-5">
						<h5 class="h5">업무소개</h5>
						<span>${ann.ann_contents }</span>
					</div>
					<div class="mb-5">
						<h5 class="h5">자격요건</h5>
						<span>${ann.ann_qualification }</span>
					</div>
					<div class="mb-5">
						<h5 class="h5">우대사항</h5>
						<span>${ann.ann_prime }</span>
					</div>
				</div>
			</div>
			<div class="col-4 mb-5">
				<div class="section">
					<h5 class="h5">회사정보</h5>
					<div class="card">
  						<div class="card-header">${com.com_name }</div>
  						<div class="card-body">
    						<ul class="list-group list-group-flush">
    							<li class="list-group-item">
    								<dl class="row">
    									<dt class="col">회사홈페이지</dt>
    									<dd class="col" style="text-align: right;"><a href="${com_homepage}">바로가기</a></dd>
    								</dl>
    								<dl class="row">
    									<dt class="col">사원수</dt>
    									<dd class="col" style="text-align: right;">${com.com_emp_num } <span style="font-size: 6pt;">명</span></dd>
    								</dl>
    								<dl class="row">
    									<dt class="col">매출</dt>
    									<dd class="col" style="text-align: right;">${com.com_sales } <span style="font-size: 6pt;">만원</span></dd>
    								</dl>
    							</li>
    							<li class="list-group-item">
    								<dl class="row">
    									<dt class="col">전화번호</dt>
    									<dd class="col" style="text-align: right;">${com.com_pno}</dd>
    								</dl>
    								<dl class="row">
    									<dt class="col">이메일</dt>
    									<dd class="col" style="text-align: right;"><span style="font-size: 8pt;">${com.com_email }</span></dd>
    								</dl>
    								<dl class="row">
    									<dt class="col">주소</dt>
    									<dd class="col" style="text-align: right;"><span style="font-size: 8pt;">${com.com_address }</span></dd>
    								</dl>
    							</li>
  							</ul>
  						</div>
					</div>
					<div class="card-header">위치</div>
					<div class="card-body col-auto" id="map">
						지도 API 연동 필요
					</div>
				</div>
			</div>
		</div>
		<div align="center">
			<c:if test="${user_dist == '1'}">
				<c:if test = "${com_num == ann.com_num }">
					<button class="btn btn-dark" type="submit" onclick="location.href='annUpdateForm.do?ann_num=${ann.ann_num}&pageNum=${pageNum}'">공고 수정</button>
					<button class="btn btn-dark" type="submit" onclick="location.href='annDeleteForm.do?ann_num=${ann.ann_num}&pageNum=${pageNum}'">공고 삭제</button>
				</c:if>
			</c:if>
		</div>
	</div>
</body>
</html>