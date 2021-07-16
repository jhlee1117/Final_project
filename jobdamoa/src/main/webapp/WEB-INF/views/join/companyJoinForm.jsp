<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path }/resources/template/js/chkJoin.js"></script>
</head>
<body>
	<div class="container px-4 px-lg-5 mt-5">
		<div class="col mb-5">
			<h2 class="text-primary">기업회원 가입</h2>
		</div>
		<form action="companyJoin.do" name="frm" method="post">
			<div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-left">
      			<table class="table table-bordered">
					<tr>
						<th width="25%" valign="middle">아이디</th>
						<td>
							<div class="col-auto">
							<input type="text" name="com_id" class="form-control w-25" required="required" autofocus="autofocus">
							</div>
							<div class="col-auto">
								<button type="button" class="btn btn-outline-primary" onclick="idComchk()">중복체크</button>
								<span id="id_check">
								</span>
							</div>
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">비밀번호</th>
						<td>
							<input type="password" name="com_password" class="form-control w-25" required="required">
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">비밀번호 확인</th>
						<td>
							<input type="password" name="com_password2" class="form-control w-25" required="required">
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">회사명</th>
						<td>
							<input type="text" name="com_name" class="form-control w-50" required="required">
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">사업자등록번호</th>
						<td>
							<input type="text" name="com_email" class="form-control w-50" required="required">
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">이메일</th>
						<td>
							<input type="email" name="com_email" class="form-control w-50" required="required">
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">회사 전화번호</th>
						<td>
							<input type="text" name="com_pno" class="form-control w-50" required="required">
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">회사 홈페이지</th>
						<td>
							<input type="url" name="com_homepage" class="form-control" required="required">
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">본사 주소</th>
						<td>
							<input type="text" name="com_address" class="form-control" required="required">
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">사원 수</th>
						<td>
							<input type="number" name="com_emp_num" min="0" required="required">
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">매출</th>
						<td>
							<input type="number" name="com_sales" min="0" required="required">
							<span style="font-size: 6pt;">만원(단위)</span>
						</td>
					</tr>										
				</table>
			</div>
		<div align="center">
			<button class="btn btn-dark" type="submit">확인</button>
			<button class="btn btn-dark" type="button" onclick="history.go(-1); return false;">취소</button>
		</div>
		</form>
	</div>
</body>
</html>