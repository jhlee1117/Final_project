<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h2 class="text-primary" align="center">${mem.mem_nickname } 회원정보</h2>
		</div>
		<div class="col mb-3">
			<table class="table table-bordered">
				<tr>
					<th width="30%" valign="middle">회원 ID</th>
					<td>${mem.mem_id }</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">닉네임</th>
					<td>${mem.mem_nickname }</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">등록 이메일</th>
					<td>${mem.mem_email }</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">가입일</th>
					<td>${mem.mem_join_date }</td>
				</tr>
			</table>
		</div>
		<div align="center">
			<button class="btn btn-dark" type="submit" onclick="location.href='memUpdateForm.do'">정보 수정</button>
			<button class="btn btn-dark" type="submit" onclick="location.href='memDeleteForm.do'">회원 탈퇴</button>
		</div>
	</div>
</div>
</body>
</html>