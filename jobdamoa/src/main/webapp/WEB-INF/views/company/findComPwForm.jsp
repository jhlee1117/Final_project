<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업회원 비밀번호 찾기</title>
<script type="text/javascript">
	function chk_null() {
		var idVal = frm.com_id.value;
		var emailVal = frm.com_email.value;
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		if (emailVal == "" || idVal == "") {
			alert("정상적으로 값이 입력되지 않았습니다.");
			if (idVal == "") {frm.com_id.focus();}
			else if (emailVal == "") {frm.com_email.focus();}
			return false;
		} else if (emailVal.match(regExp) == null) {
			alert("이메일 형식이 아닙니다.");
			frm.com_email.focus();
			return false;
		} else {
			return true;
		}
	};
</script>
</head>
<body>
	<form action="pwComAuth.do" name="frm" method="post"
		onsubmit="return chk_null()">
		<div class="card w-100 text-center">
			<div class="card-body">
				<h6>아이디를 입력하세요.</h6>
				<div class="form-floating mb-3">
					<input type="text" name="com_id" class="form-control" id="com_id"
						placeholder="ID"> <label for="com_id">ID</label>
				</div>
				<h6>이메일을 입력하세요.</h6>
				<div class="form-floating mb-3">
					<input type="text" name="com_email" class="form-control"
						id="com_email" placeholder="E-mail"> <label
						for="com_email">E-mail</label>
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