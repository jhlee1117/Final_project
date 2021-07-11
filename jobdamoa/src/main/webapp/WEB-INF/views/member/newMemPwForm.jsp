<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$(".passchk").keyup(function() {
			var pass = $("#pass").val();
			var confirmPass = $("#confirmPass").val();
			if (pass != "" || confirmPass != "") {
				if (pass == confirmPass) {
					$("#alert-success").show();
					$("#alert-danger").hide();
					$("#submit").removeAttr("disabled");
				} else {
					$("#alert-success").hide();
					$("#alert-danger").show();
					$("#submit").attr("disabled", "disabled");
				}
			}
		});
	});
</script>
</head>
<body>
	<form action="newMemPw.do" name="frm" method="post"
		onsubmit="return chk_null()">
		<input type="hidden" name="mem_id" value="${mem_id }">
		<div class="card w-100 text-center">
			<div class="card-body">
				<h6>새로운 비밀번호를 입력하세요.</h6>
				<div class="form-floating mb-3">
					<input type="password" name="mem_password" class="form-control passchk"
						id="pass" placeholder="Password"> <label
						for="pass">비밀번호</label>
				</div>
				<h6>비밀번호를 다시 한번 더 확인해주세요.</h6>
				<div class="form-floating mb-3">
					<input type="password" name="mem_password2" class="form-control passchk"
						id="confirmPass" placeholder="Password"> <label
						for="confirmPass">비밀번호 확인</label>
				</div>
				<div id="alert-success">비밀번호가 일치합니다.</div>
				<div id="alert-danger">비밀번호가 일치하지 않습니다.</div>
			</div>
			<div class="card-footer">
				<button type="submit" class="btn btn-primary" id="submit">확인</button>
				<button type="button" class="btn btn-danger"
					onclick="window.close()">닫기</button>
			</div>
		</div>
	</form>
</body>
</html>