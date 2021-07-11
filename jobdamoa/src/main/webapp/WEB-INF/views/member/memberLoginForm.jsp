<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function findMemId() {
		var url = "findMemIdForm.do";
		var name = "기업회원 ID 찾기";
		var option = "width = 500, height = 300, top = 100, left = 200, location = no"
		window.open(url, name, option);
	}
	function findMemPw() {
		var url = "findMemPwForm.do";
		var name = "기업회원 비밀번호 찾기";
		var option = "width = 500, height = 300, top = 100, left = 200, location = no"
		window.open(url, name, option);
	}
</script>
</head>
<body>
	<div class="container px-4 px-lg-5 mt-5">
		<form action="memberLogin.do" method="post">
			<div class="card w-50 text-center">
				<div class="card-header">
					<h2>일반회원 로그인</h2>
				</div>
				<div class="card-body">
					<div class="form-floating mb-3">
						<input type="text" name="mem_id" class="form-control" id="mem_id"
							placeholder="ID"> <label for="com_id">ID</label>
					</div>
					<div class="form-floating">
						<input type="password" name="mem_password" class="form-control"
							id="mem_password" placeholder="Password"> <label
							for="mem_password">Password</label>
					</div>
				</div>
				<div class="card-footer">
					<button type="submit" class="btn btn-primary">확인</button>
					<button type="button" class="btn btn-danger"
						onclick="history.go(-1); return false;">취소</button>
				</div>
			</div>
		</form>
		<div>
			<span><a href="javascript:findMemId()">ID 찾기</a></span> <span><a
				href="javascript:findMemPw()">비밀번호 찾기</a></span>
		</div>
	</div>
</body>
</html>	