<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container px-4 px-lg-5 mt-5">
		<div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-left">
			<div class="col-9 mb-5">
				<h2 class="h2">${ann.ann_title}</h2>
				<h4 class="h4">${com.com_name }</h4>
			</div>
			<div class="col-3 mb-5"	>
				<a class="btn btn-outline-dark mt-auto" href="#">공고 저장하기</a>				
			</div>
		</div>
		<div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-left">
		<div class="col-9 mb-5">
		<table class="table table-bordered">
				<tr>
					<th width="30%" valign="middle">직무</th>
					<td>
						${ann.ann_job }
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">고용형태</th>
					<td>
						<c:if test="${ann.ann_type == 'regular' }">
							정규직
						</c:if>
						<c:if test="${ann.ann_type == 'contract' }">
							계약직
						</c:if>
						<c:if test="${ann.ann_type == 'intern' }">
							인턴
						</c:if>
						<c:if test="${ann.ann_type == 'rest' }">
							기타
						</c:if>
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">경력여부</th>
					<td>
						<c:if test="${ann.ann_career == 'new' }">
							신입
						</c:if>
						<c:if test="${ann.ann_career == 'old' }">
							경력
						</c:if>
						<c:if test="${ann.ann_career == 'okay' }">
							경력무관
						</c:if>
					</td>
				</tr>
			</table>
			</div>
		</div>
	</div>
</body>
</html>