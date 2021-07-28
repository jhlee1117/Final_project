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
			<h2 class="text-primary">일반회원 가입</h2>
		</div>
		<form action="memberJoin.do" name="frm" method="post">
			<div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-left">
      			<table class="table table-bordered">
					<tr>
						<th width="25%" valign="middle">아이디</th>
						<td>
							<div class="col-auto">
							<input type="text" name="mem_id" class="form-control w-25" required="required" autofocus="autofocus">
							</div>
							<div class="col-auto">
								<button type="button" class="btn btn-outline-primary" onclick="idMemchk()">중복체크</button>
								<span id="id_check">
								</span>
							</div>
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">비밀번호</th>
						<td>
							<input type="password" name="mem_password" id="pass" class="form-control w-25 passchk" required="required">
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">비밀번호 확인</th>
						<td>
							<input type="password" name="mem_password2" id="confirmPass" class="form-control w-25 passchk" required="required">
							<div id="alert-success">비밀번호가 일치합니다.</div>
							<div id="alert-danger">비밀번호가 일치하지 않습니다.</div>
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">닉네임</th>
						<td>
							<input type="text" name="mem_nickname" class="form-control w-50" required="required">
						</td>
					</tr>
					<tr>
						<th width="25%" valign="middle">이메일</th>
						<td>
							<input type="email" name="mem_email" class="form-control w-50" 
							pattern="^[0-9a-zA-Z]([-_￦.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_￦.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$" 
							placeholder="korea@gmail.com" required="required">
						</td>
					</tr>										
				</table>
			</div>
		<div align="center">
			<button class="btn btn-dark" id="submit" type="submit">확인</button>
			<button class="btn btn-dark" type="button" onclick="location.href='memberLoginForm.do'">취소</button>
		</div>
		</form>
	</div>
</body>
</html>