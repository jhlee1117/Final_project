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
			<h2 class="text-primary" align="center">${mem.mem_nickname } 회원정보</h2>
		</div>
		<form action="annUpdate.do" name="frm" method="post">
			<div class="col mb-3">
				<input type="hidden" name="mem_num" value="${mem.mem_num }">
				<table class="table table-bordered">
					<tr>
						<th width="30%" valign="middle">회원 ID</th>
						<td>${mem.mem_id }</td>
					</tr>
					<tr>
						<th width="30%" valign="middle">닉네임</th>
						<td>
							<input type="text" name="mem_nickname" value="${mem.mem_nickname }" class="form-control w-50" required="required">
						</td>
					</tr>
					<tr>
						<th width="30%" valign="middle">등록 이메일</th>
						<td>
							<input type="email" name="mem_email" value="${mem.mem_email }" class="form-control w-50" 
								pattern="^[0-9a-zA-Z]([-_￦.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_￦.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$" 
								placeholder="korea@gmail.com" required="required">
							<button type="button" class="btn btn-outline-dark" onclick="checkMem_email()">이메일 중복체크</button>
							<span id="email_check"></span>
						</td>
					</tr>
					<caption>비밀번호 수정</caption>
					<tr>
					</tr>
				</table>
			</div>
		</form>
		<div align="center">
			<button class="btn btn-dark" type="submit" id="submit" onclick="location.href='memUpdate.do'">수정 완료</button>
			<button class="btn btn-dark" type="button" id="submit" onclick="history.go(-1); return false;">취소</button>
		</div>
	</div>
</div>
</body>
</html>