<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function findComId() {
		var url = "findComIdForm.do";
		var name = "기업회원 ID 찾기";
		var option = "width = 500, height = 300, top = 100, left = 200, location = no"
		window.open(url, name, option);
	}
	function findComPw() {
		var url = "findComPwForm.do";
		var name = "기업회원 비밀번호 찾기";
		var option = "width = 500, height = 300, top = 100, left = 200, location = no"
		window.open(url, name, option);
	}
</script>
</head>
<body>
	<div class="container px-4 px-lg-5 mt-5">
		<form action="companyLogin.do" method="post">
			<input type="hidden" name="user_dist" value="1">
			<div class="card w-50 text-center">
				<div class="card-header">
					<h2>기업회원 로그인</h2>
				</div>
				<div class="card-body">
					<div class="form-floating mb-3">
						<input type="text" name="com_id" class="form-control" id="com_id" 
							placeholder="ID"> <label for="com_id">ID</label>
					</div>
					<div class="form-floating">
						<input type="password" name="com_password" class="form-control" id="com_password"
							placeholder="Password"> <label for="com_password">Password</label>
					</div>
				</div>
				<div class="card-footer">
					<button type="submit" class="btn btn-primary">확인</button>
					<button type="button" class="btn btn-danger" onclick="history.go(-1); return false;">취소</button>
				</div>
			</div>
		</form>
		<div>
			<span><a href="javascript:findComId()">ID 찾기</a></span>
			<span><a href="javascript:findComPw()">비밀번호 찾기</a></span>
		</div>
	</div>
</body>
</html>