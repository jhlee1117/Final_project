<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반회원 비밀번호 찾기</title>
<script type="text/javascript">
	function chk_null() {
		var idVal = frm.mem_id.value;
		var emailVal = frm.mem_email.value;
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		if (emailVal == "" || idVal == "") {
			alert("정상적으로 값이 입력되지 않았습니다.");
			if (idVal == "") {frm.mem_id.focus();}
			else if (emailVal == "") {frm.mem_email.focus();}
			return false;
		} else if (emailVal.match(regExp) == null) {
			alert("이메일 형식이 아닙니다.");
			frm.mem_email.focus();
			return false;
		} else {
			return true;
		}
	};
</script>
</head>
<body>
	<form action="pwMemAuth.do" name="frm" method="post"
		onsubmit="return chk_null()">
		<div class="card w-100 text-center">
			<div class="card-body">
				<h6>아이디를 입력하세요.</h6>
				<div class="form-floating mb-3">
					<input type="text" name="mem_id" class="form-control" id="mem_id"
						placeholder="ID"> <label for="mem_id">ID</label>
				</div>
				<h6>이메일을 입력하세요.</h6>
				<div class="form-floating mb-3">
					<input type="text" name="mem_email" class="form-control"
						id="mem_email" placeholder="E-mail"> <label
						for="mem_email">E-mail</label>
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