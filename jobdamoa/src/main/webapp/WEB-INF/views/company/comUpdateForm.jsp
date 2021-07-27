<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path }/resources/template/js/chkUpdate.js"></script>
</head>
<body>
<div class="container px-4 px-lg-5 mt-5">
	<div class="row gx-4 gx-lg-5 row-cols-1">
		<div class="col mb-5">
			<h2 class="text-primary" align="center">${com.com_name } 기업정보</h2>
		</div>
		<form action="comUpdate.do" name="frm" method="post">
			<div class="col mb-3">
				<input type="hidden" name="com_num" value="${com.com_num }">
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
						<td>
							<input type="text" name="com_pno" class="form-control w-50" value="${com.com_pno }" required="required" 
							title="전화형식 3-3,4-4" pattern="\d{3}-\d{3,4}-\d{4}" placeholder="010-1111-1111">
							<button type="button" class="btn btn-outline-dark" onclick="checkCom_pno()">연락처 중복체크</button>
							<span id="pno_check"></span>
						</td>
					</tr>
					<tr>
						<th width="30%" valign="middle">대표 이메일</th>
						<td>
							<input type="email" name="com_email" class="form-control w-50" value="${com.com_email }" 
							pattern="^[0-9a-zA-Z]([-_￦.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_￦.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$" 
							placeholder="korea@gmail.com" required="required">
							<button type="button" class="btn btn-outline-dark" onclick="checkCom_email()">이메일 중복체크</button>
							<span id="email_check"></span>
						</td>
					</tr>
					<tr>
						<th width="30%" valign="middle">본사 주소</th>
						<td>
							<input type="text" name="com_address" class="form-control" value="${com.com_address }" required="required">
						</td>
					</tr>
					<tr>
						<th width="30%" valign="middle">사원 수</th>
						<td>
							<input type="number" name="com_emp_num" min="0" value="${com.com_emp_num }" required="required">
						</td>
					</tr>
					<tr>
						<th width="30%" valign="middle">연간 매출</th>
						<td>
							<input type="number" name="com_sales" min="0" value="${com.com_sales }" required="required">
							<span style="font-size: 6pt;">만원(단위)</span>
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">회사 홈페이지</th>
						<td>
							<input type="url" name="com_homepage" value="${com.com_homepage }" class="form-control">
						</td>
					</tr>
					<tr>
						<th width="30%" valign="middle">비밀번호 수정</th>
						<td>
							<input type="password" name="com_password" id="pass" class="form-control w-25 passchk" required="required">
						</td>
					</tr>
					<tr>
						<th width="30%" valign="middle">비밀번호 확인</th>
						<td>
							<input type="password" name="com_password2" id="confirmPass" class="form-control w-25 passchk" required="required">
							<div id="alert-success">비밀번호가 일치합니다.</div>
							<div id="alert-danger">비밀번호가 일치하지 않습니다.</div>
						</td>
					</tr>					
				</table>
			</div>
		<div align="center">
			<input class="btn btn-dark" type="submit" id="submit" value="수정 완료">
			<input class="btn btn-dark" type="button" id="button" value="취소" onclick="history.go(-1); return false;">
		</div>	
		</form>
	</div>
</div>
</body>
</html>