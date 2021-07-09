<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업회원 ID 찾기</title>
<script type="text/javascript">
	function chk_email() {

		var emailVal = frm.com_email.value;
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		if (emailVal == "") {
			alert("이메일이 입력되지 않았습니다.");
			frm.com_email.focus();
			return false;
		} else if (emailVal.match(regExp) == null) {
			alert("이메일 형식이 아닙니다.");
			frm.com_email.focus();
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<form action="findComId.do" name="frm" method="post"
		onsubmit="return chk_email()">
		<div class="card w-100 text-center">
			<div class="card-body">
				<h6>등록하신 이메일을 입력하세요.</h6>
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