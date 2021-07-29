<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container px-4 px-lg-5 mt-5" style="min-height:662px">
	<div class="row gx-4 gx-lg-5 row-cols-1">
		<div class="col mb-5">
			<h2 class="text-primary" align="center">${com.com_name } 기업정보</h2>
		</div>
		<div class="col mb-3">
			<table class="table table-bordered">
				<tr>
					<th width="30%" valign="middle">기업 ID</th>
					<td>${com.com_id }</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">기업명</th>
					<td>${com.com_name }</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">사업자등록번호</th>
					<td>${com.com_business_num }</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">대표 연락처</th>
					<td>${com.com_pno }</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">대표 이메일</th>
					<td>${com.com_email }</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">사업장 소재지</th>
					<td>${com.com_address }</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">사원 수</th>
					<td>${com.com_emp_num } <span style="font-size: 6pt;">명</span></td>
				</tr>
				<tr>
					<th width="30%" valign="middle">연간 매출</th>
					<td>${com.com_sales } <span style="font-size: 6pt;">만원</span></td>
				</tr>
				<tr>
					<th width="30%" valign="middle">대표 홈페이지</th>
					<td>
						<c:if test="${empty com.com_homepage }">
						등록된 홈페이지가 없습니다.
						</c:if>
						<c:if test="${not empty com.com_homepage }">
							<a href="${com.com_homepage}">바로가기</a>
						</c:if> 
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
			<button class="btn btn-dark" type="submit" onclick="location.href='comUpdateForm.do'">정보 수정</button>
			<button class="btn btn-dark" type="submit" onclick="location.href='comDeleteForm.do'">회원 탈퇴</button>
		</div>
	</div>
</div>
</body>
</html>