<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var time = 180;
	var min = "";
	var sec = "";
	
	var x = setInterval(function() {
		min = parseInt(time/60);
		sec = time%60;
		
		document.getElementById("timer").innerHTML = min + "분 " + sec + "초";
		time --;
		
		if (time < 0) {
			clearInterval(x);
			document.getElementById("timer").innerHTML = "인증 시간 만료";
			alert("인증 시간이 만료되었으니, 재인증 해주시기 바랍니다.");
			history.back();
		}
	}, 1000);
</script>
</head>
<body>
	<form action="pwComSet.do" method="post">
		<input type="hidden" name="num" value="${num }">
		<div class="card w-100 text-center">
			<div class="card-body">
				<h6>인증번호를 입력하세요.</h6>
				<div class="form-floating mb-3">
					<input type="text" name="auth_num" class="form-control"
						id="auth_num" placeholder="인증번호"> <label for="auth_num">인증번호</label>
					<span id="timer"></span>
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