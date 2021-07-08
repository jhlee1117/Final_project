<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container px-4 px-lg-5 mt-5">
		<form action="companyLogin.do" method="post">
			<div class="card w-50 text-center">
				<div class="card-header">
					<h2>기업회원 로그인</h2>
				</div>
				<div class="card-body">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="com_id"
							placeholder="ID"> <label for="com_id">ID</label>
					</div>
					<div class="form-floating">
						<input type="password" name="com_password" class="form-control" id="com_password"
							placeholder="Password"> <label for="com_password">Password</label>
					</div>
				</div>
				<div class="card-footer">
					<button type="submit" class="btn btn-primary">확인</button>
					<button type="button" class="btn btn-danger">취소</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>