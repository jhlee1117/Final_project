<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="pwComSet.do" method="post">
		<input type="hidden" name="num" value="${num }">
		<div class="card w-100 text-center">
			<div class="card-body">
				<h6>인증번호를 입력하세요.</h6>
				<div class="form-floating mb-3">
					<input type="text" name="auth_num" class="form-control"
						id="auth_num" placeholder="인증번호"> <label
						for="auth_num">인증번호</label>
				</div>
			</div>
			<div class="card-footer">
				<button type="submit" class="btn btn-primary">확인</button>
				<button type="button" class="btn btn-danger"
					onclick="window.close()">닫기</button>
			</div>
		</div>
	</form>
</body>
</html>