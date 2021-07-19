<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		delchk = confirm("정말로 탈퇴하시겠습니까?");
		if (delchk == true) {
			location.href="memDelete.do";
		} else {
			alert("탈퇴를 취소하였습니다.");
			history.go(-1);
		}
	}
</script>
</head>
<body>
</body>
</html>